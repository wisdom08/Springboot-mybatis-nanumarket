$(document).ready(() => {

    var message = {
        LOGIN_FAILED: "아이디나 비밀번호를 확인해주세요"
    }

    function checkDup(value) {
        $.ajax({
            url: '/join/check/email',
            method: 'POST',
            data: {
                value
            },
            success: function (res) {
                if (res.dup) {
                    $('.alert-email').show()
                }
            }
        })
    }

    function checkDupId(id) {
        $.ajax({
            url: '/join/check/id',
            method: 'POST',
            data: {
                id
            },
            success: function (res) {
                if (res.dup) {
                    $('.alert-id').show()
                }
            }
        })
    }

    function tryJoin(id, email, pw){
        $.ajax({
            url: '/join',
            method: 'POST',
            data: {
                id, email, pw
            },
            success: function (res) {
                if (res.success) {
                    alert("join success")
                    location.href = "/"
                } else {
                    let err = res.cause
                    let msg = message[err]
                    alert(msg)
                }
            }

        })
    }


    $('#email')
        .on('blur', (e) => {
            console.log('[blur]', e.target.value)
            checkDup(e.target.value)
        })

        .on('input', (e) => {
            console.log('[input]', "이메일 쓰는 중")
            $('.alert-email').hide()
        })

    $('#id')
        .on('blur', (e) => {
            console.log('[blur]', e.target.value)
            checkDupId(e.target.value)
        })

        .on('input', (e) => {
            console.log('[input]', "아이디 쓰는 중")
            $('.alert-id').hide()
        })




    $('.btn-join')
        .on('click', (e) => {
            let id = $('#id').val()
            let email = $('#email').val()
            let pw = $('#pw').val()
            tryJoin(id, email, pw)
        })

    $('#pw2')
        .blur(function(){
            if ($('#pw').val() != $('#pw2').val()) {
                if($('#pw2').val() != ''){

                    alert('비밀번호가 일치하지 않습니다.')
                    $('#pw2').val('')
                    $('#pw2').focus()
                }
            }
        })
})