/*!

 =========================================================
 * Paper Bootstrap Wizard - v1.0.2
 =========================================================
 
 * Product Page: https://www.creative-tim.com/product/paper-bootstrap-wizard
 * Copyright 2017 Creative Tim (#)
 * Licensed under MIT (https://github.com/creativetimofficial/paper-bootstrap-wizard/blob/master/LICENSE.md)
 
 =========================================================
 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 */

// Paper Bootstrap Wizard Functions

searchVisible = 0;
transparent = true;

$(document).ready(function() {

    /*  Activate the tooltips      */
    $('[rel="tooltip"]').tooltip();

    // Code for the Validator
    var $validator = $('.wizard-card form').validate({
        rules: {
            flag: {
                required: true,
            },
            w: {
                required: true,
                number: true
            },
            hg: {
                required: true,
                number: true
            },
            wr: {
                required: true,
                number: true
            },
            car_l: {
                required: true,
                number: true
            },
            car_slr: {
                required: true,
                number: true
            }
        },
    });

    // Wizard Initialization
    $('.wizard-card').bootstrapWizard({
        'tabClass': 'nav nav-pills',
        'nextSelector': '.btn-next',
        'previousSelector': '.btn-previous',

        onNext: function(tab, navigation, index) {
            var $valid = $('.wizard-card form').valid();
            if (!$valid) {
                $validator.focusInvalid();
                return false;
            }
            if (index == 1) {
                _calSimilarModel()
            } else if (index == 3) {
                _calOptimization()
            }
            // console.log(tab)
            // console.log(navigation)
            // console.log(index)
        },

        onInit: function(tab, navigation, index) {

            //check number of tabs and fill the entire row
            var $total = navigation.find('li').length;
            $width = 100 / $total;

            navigation.find('li').css('width', $width + '%');

        },

        onTabClick: function(tab, navigation, index) {

            var $valid = $('.wizard-card form').valid();

            if (!$valid) {
                return false;
            } else {
                // console.log(index)
                // if(index == 0){
                //     _calSimilarModel()
                // }
                // console.log(tab)
                // console.log(navigation)
                // console.log(index)
                // var $select = $("li.active > a").attr("href")
                // console.log($("li.active > a").attr("href"))
                // if($select.indexOf("model")){
                //     // _calSimilarModel()
                // }else if($select.indexOf("optimization")){
                //     alert("hehe opt")
                // }
                // if($('#model-table-body').is(':empty')){
                //     _calSimilarModel()
                //     _calOptimization()
                // }

                return true;

            }


        },

        onTabShow: function(tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index + 1;

            var $wizard = navigation.closest('.wizard-card');

            // If it's the last tab then hide the last button and show the finish instead
            if ($current >= $total) {
                $($wizard).find('.btn-next').hide();
                $($wizard).find('.btn-finish').show();
            } else {
                $($wizard).find('.btn-next').show();
                $($wizard).find('.btn-finish').hide();
            }

            //update progress
            var move_distance = 100 / $total;
            move_distance = move_distance * (index) + move_distance / 2;

            $wizard.find($('.progress-bar')).css({
                width: move_distance + '%'
            });
            //e.relatedTarget // previous tab

            $wizard.find($('.wizard-card .nav-pills li.active a .icon-circle')).addClass('checked');

        }
    });


    // Prepare the preview for profile picture
    $("#wizard-picture").change(function() {
        readURL(this);
    });

    $('[data-toggle="wizard-radio"]').click(function() {
        wizard = $(this).closest('.wizard-card');
        wizard.find('[data-toggle="wizard-radio"]').removeClass('active');
        $(this).addClass('active');
        $(wizard).find('[type="radio"]').removeAttr('checked');
        $(this).find('[type="radio"]').attr('checked', 'true');
    });

    $('[data-toggle="wizard-checkbox"]').click(function() {
        if ($(this).hasClass('active')) {
            $(this).removeClass('active');
            $(this).find('[type="checkbox"]').removeAttr('checked');
        } else {
            $(this).addClass('active');
            $(this).find('[type="checkbox"]').attr('checked', 'true');
        }
    });

    $('.set-full-height').css('height', 'auto');

});



//Function to show image before upload

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
            $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
        }
        reader.readAsDataURL(input.files[0]);
    }
}

var _calSimilarModel = function() {
    var parameters = {}
    if ($("#LVM").is(":checked")) {
        parameters.flag = 0
    } else {
        parameters.flag = 1
    }
    var $form = document.getElementById("parameters-form");
    var $inputs = $form.getElementsByTagName('input');
    for (var i = 0; i < $inputs.length; i++) {
        if ($inputs[i].type != "radio") {
            parameters[$inputs[i].name] = $inputs[i].value
        }
    }
    // var expert_similar_url = "http://100.64.3.181:8080/expert/similar"
    var expert_similar_url = "/similar"
    console.log(parameters)
    $.ajax({
        type: "POST",
        url: expert_similar_url,
        // jsonp:"callback",
        async: false,
        header: {
            'content-type': 'application/json'
        },
        data: parameters,
        success: function(dataSource) {
            console.log("similar")
            console.log(dataSource)
            console.log(dataSource.results)
            _loadModelTable(dataSource.results)
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            console.log('model error');
            console.log(errorThrown);
        }
    });
}

var _loadModelTable = function(dataSource) {
    // console.log(dataSource);
    var $table_body = document.getElementById("model-table-body");
    $("#model-table-body").empty()
        // while($table.hasChildNodes()){ $table.removeChild($table.firstChild)};
    var results = Object.getOwnPropertyNames(dataSource)
    if (results) {
        for (var i = 0; i < results.length; i++) {
            var tr = document.createElement("tr");
            var td_name = $("<td>" + results[i] + "</td>")
            td_name.appendTo(tr)
            var td_value = $("<td>" + dataSource[results[i]] + "</td>")
            if (results[i] == 'id') {
                td_value.attr('id', 'vehicle_id')
            }
            td_value.appendTo(tr)
            $table_body.appendChild(tr);
        }

    }
}

var _calOptimization = function() {
    parameters = {}
    var cookie = checkCookie()
    parameters.user_id = cookie.userid
    if ($("#LVM").is(":checked")) {
        parameters.v_type = 0
    } else {
        parameters.v_type = 1
    }
    parameters.vehicle_id = $("#vehicle_id").text()
    if ($("#price").is(":checked")) {
        parameters.op_type = 0
    } else {
        parameters.op_type = 1
    }
    console.log(parameters)
        // var instance_url = "http://100.64.3.181:8080/expert/instance"
    var instance_url = "/instance"
    $.ajax({
        type: "POST",
        url: instance_url,
        // jsonp:"callback",
        header: {
            'content-type': 'application/json'
        },
        data: parameters,
        success: function(dataSource) {
            console.log("instance")
            console.log(dataSource)
            results = dataSource.results
            if (results) {
                _loadOptimizationTable(results)
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            console.log('model error');
            console.log(errorThrown);
        }
    });
}

var _loadOptimizationTable = function(data) {
    var results = Object.getOwnPropertyNames(data)
    for (var i = 0; i < results.length; i++) {
        if (results[i] == 'instance') {
            var $table_body = $("#instance-table-body")
            $("#instance > caption").attr('id', data[results[i]][0][2])
        } else {
            $table = $("<table></table>");
            $table.attr('id', results[i])
            $table.addClass("table table-hover")
            var $caption = $("<caption></caption>");
            $caption.text(results[i])
            $caption.appendTo($table)
            $table_body = $("<tbody></tbody>")
            $table_body.appendTo($table)
        }

        for (var j = 0; j < data[results[i]].length; j++) {
            var tr = $("<tr></tr>");
            for (var s = 0; s < data[results[i]][j].length; s++) {
                var td = $("<td>" + data[results[i]][j][s] + "</td>")
                td.appendTo(tr)
            }
            tr.appendTo($table_body)
        }

        if (results[i] != 'instance') {
            var $table_area = $("#optimization-table-area")
            $table.appendTo($table_area)
        }
    }
    var id = $("#instance > caption").attr("id")
    console.log(id)
    // var download_url = "http://100.64.3.181:8080/expert/download/instance/" + id
    var download_url = "/download/instance/" + id
    $("#download-instance").attr('href', download_url)
}

$(function() {
    $("#model-li").click(function() {
        _calSimilarModel()
    })
})

$(function() {
    $("#optimization-li").click(function() {
        if ($('#model-table-body').is(':empty')) {
            _calSimilarModel()
            _calOptimization()
        } else {
            _calOptimization()
        }
    })
})