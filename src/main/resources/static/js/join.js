$(document).ready(() => {


    let msg = {
        SHORT_PW: '비번이 짧아요',
        DUP_ID: '존재하는 아이디',
        DUP_EMAIL: '존재하는 이메일',
        LOGIN_FAILED: "아이디나 비밀번호를 확인해주세요"
    }

    function error(code) { // 'SHORT_PW'
        let m = msg[code]   //msg['SHORT_PW'] msg.get(code)
        return m || `오류발생(${code})`
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
            },
            // error(e) {
            //     //400 , 403 ...
            //     console.log(e)
            // }
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

    function tryJoin(id, email, pw, callback){
        $.ajax({
            url: '/tryJoin',
            method: 'POST',
            data: {
                id, email, pw
            },
            success(res){
                callback(res)
            },
            error(e) {
                //400 , 403 ...
                console.log( e )
                let msg = error(e.responseJSON.cause)
                alert(msg)

            }
        })
    }


    $('#email')
        .on('blur', (e) => {
            console.log('[blur]', e.target.value)
            checkDup(e.target.value)
        })

        .on('input', (e) => {
            console.log("[input], 이메일 쓰는 중")
            $('.alert-email').hide()
        })

    $('#id')
        .on('blur', (e) => {
            console.log('[blur]', e.target.value)
            checkDupId(e.target.value)
        })

        .on('input', (e) => {
            console.log("아이디 쓰는 중")
            $('.alert-id').hide()
        })




    $('.btn-join')
        .on('click', (e) => {
            let id = $('#id').val()
            let email = $('#email').val()
            let pw = $('#pw').val()
            tryJoin(id, email, pw, (res) => {
                if (res.success) {
                    alert("성공")
                    location.href ="/"
                } else {
                    let msg = error(res.cause)
                }
            })
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