/**
 * Created by chenweiyi on 02/07/2017.
 */

$(function() {
    var checkResult = checkCookie();
    console.log(checkResult)
    if (!(checkResult.username && checkResult.password && checkResult.userid)) {
        window.location.href = "/login";
    }
})

$(function() {
    var cookie = checkCookie()
    var userId = cookie.userid
        // var userId = "1"
        // var all_instance_url = "http://100.64.3.181:8080/expert/allInstance/" + userId
    var all_instance_url = "/allInstance/" + userId
    $.ajax({
        type: "get",
        url: all_instance_url,
        // dataType: "json",
        jsonp: "callback",
        success: function(data) {
            var results = data.results;
            console.log(results)
            if (results.length) {
                _loadAllInstanceTable(results)
            }

        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            console.log('all instance error');
            console.log(errorThrown);
        }
    })
})

var _loadAllInstanceTable = function(data) {
    var columns = Object.getOwnPropertyNames(data[0])
    var index = columns.indexOf("geneTime")
    columns.splice(index, 1);
    // columns.push("download")
    console.log(columns)
    var $thead = $("<thead></thead>");
    var $thead_tr = $("<tr></tr>");
    $thead_tr.appendTo($thead)
    var $tbody = $("<tbody></tbody>")
    for (var i = 0; i < data.length; i++) {
        var $tr = $("<tr></tr>");
        for (var j = 0; j < columns.length; j++) {
            if (i == 0) {
                var $th = $("<th>" + columns[j] + "</th>")
                $th.appendTo($thead_tr)
            }
            var $td = $("<td>" + data[i][columns[j]] + "</td>")
            $td.appendTo($tr)
        }
        if (i == 0) {
            var $th = $("<th>download</th>")
            $th.appendTo($thead_tr)
        }
        var $download_td = $("<td></td>")
        var $a = $("<a><i class=\"ti-download\"></i></a>")
            // var download_url = "http://100.64.3.181:8080/expert/download/instance/" + data[i].id
        var download_url = "/download/instance/" + data[i].id
        $a.attr("href", download_url)
        $a.appendTo($download_td)
        $download_td.appendTo($tr)
        $tr.appendTo($tbody)
    }
    var $table = $("#history-table")
    $thead.appendTo($table)
    $tbody.appendTo($table)
}