$(document).ready(()=>{

    let message = {
        LOGIN_FAILED: "아이디나 비밀번호를 확인해주세요."
    }

    function tryLogin(id, password){
        $.ajax({
            url: '/login',
            method: 'POST',
            data: {id, password},
            success: function (res) {
                if(res.success){
                    alert('로그인 성공')
                    location.href = res.nextUrl
                } else {
                    let msg = message["LOGIN_FAILED"]
                    alert(msg)
                }
            }
        })
    }


    $('.btn-login').on('click', (e) => {
      let id = $('#id').val();
      let password = $('#password').val();
      tryLogin(id,password)
    })
})