/**
 * Created by chenweiyi on 02/07/2017.
 */

$(function () {
    var checkResult = checkCookie();
    console.log(checkResult)
    if((checkResult.username && checkResult.password && checkResult.userid)){
        window.location.href = "/design";
    }
})