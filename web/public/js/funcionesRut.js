/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function formatoRut(obj) {
    var input_rut = document.getElementById(obj.id);
    var rut = input_rut.value;
    rut = rut.replace(/\./g, "");
    rut = rut.replace(/\-/g, "");
    var cont = 1;
    var rut_tmp = '';
    var flag_guion = true;
    var div = 5;
    for (var i = rut.length - 1; i >= 0; i--) {
        if (cont % 2 === 0 && flag_guion) {
            rut_tmp += '-' + rut.substr(i, 1);
            flag_guion = !flag_guion;
        } else if (cont % div === 0) {
            rut_tmp += '.' + rut.substr(i, 1);
            div += 3;
        } else {
            rut_tmp += rut.substr(i, 1);
        }
        cont++;
    }
    var rut_f = '';
    for (var i = rut_tmp.length - 1; i >= 0; i--) {
        rut_f += rut_tmp.substr(i, 1);
    }
    input_rut.value = rut_f;
}

function isCharRut(evt, obj) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    var input_rut = document.getElementById(obj.id);
    var rut = input_rut.value;
    if (rut.length > 11) {
        return false;
    }
    if (rut.length > 8 && (charCode === 107 || charCode === 75) && rut.indexOf('k') === -1 && rut.indexOf('K') === -1) {
        return true;
    } else if (47 < charCode && charCode < 58 && rut.indexOf('k') === -1 && rut.indexOf('K') === -1) {
        return true;
    }
    return false;
}


