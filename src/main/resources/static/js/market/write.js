$(document).ready(() => {

    var $wrapper = $('body > .container-fluid')

    function handleSubmit(e) {
        // 1. title
        // 2. content
        // 3. pics
        var loc = 0 // 위도
        var lng = 0 // 경도
        var frm = new FormData()
        var title = $wrapper.find('input[type="text"]').val()
        frm.append('title', title)

        var content = $wrapper.find('textarea').val()
        frm.append('content', content)

        var $upfiles = $wrapper.find('.upfiles > input[type="file"]')
        $upfiles.each((index, el) => {
            var file = el.files[0]
            frm.append('upfiles', file)
        })

        $.ajax({
            url: '/market/write',
            method: 'POST',
            data: frm,
            processData: false,
            contentType: false,
            success(res) {
                console.log(res)
            },
            error(e) {
                console.log(e)
            }
        })

    }

    function showMap() {
        // TODO 사용자가 주소 검색해서 특정 위치로 이동하는 기능(주소로 장소 표시하기), (중심좌표 변경 이벤트 등록하기)
        $('.map-wrapper').css({
            display: 'block',
            position: 'fixed',
            top: 0,
            right: 0,
            left: 0,
            bottom: 0,
        })

        var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 10 // 지도의 확대 레벨
            };

        var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다




// HTML5의 geolocation으로 사용할 수 있는지 확인합니다
        if (navigator.geolocation) {

            // GeoLocation을 이용해서 접속 위치를 얻어옵니다
            navigator.geolocation.getCurrentPosition(function (position) {

                var lat = position.coords.latitude, // 위도
                    lon = position.coords.longitude; // 경도

                var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
                    message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다

                // 마커와 인포윈도우를 표시합니다
                displayMarker(locPosition, message);

            });

        } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

            var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
                message = 'geolocation을 사용할수 없어요..'

            displayMarker(locPosition, message);



        }



// 지도에 마커와 인포윈도우를 표시하는 함수입니다
        function displayMarker(locPosition, message) {

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: locPosition,
            });






            var iwContent = message, // 인포윈도우에 표시할 내용
                iwRemoveable = true;

            // 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: iwContent,
                removable: iwRemoveable
            });

            // 인포윈도우를 마커위에 표시합니다
            infowindow.open(map, marker);

            // 지도 중심좌표를 접속위치로 변경합니다
            map.setCenter(locPosition);



        }


        kakao.maps.event.addListener(map, 'click', function(mouseEvent) {





            // 클릭한 위도, 경도 정보를 가져옵니다
            var latlng = mouseEvent.latLng;



            var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
            message += '경도는 ' + latlng.getLng() + ' 입니다';

            var resultDiv = document.getElementById('result');
            resultDiv.innerHTML = message;


        });

    };

        $wrapper
        .on('click', '[data-cmd="submit"]',handleSubmit)
        .on('click', '[data-cmd="show-map"]', showMap)
})