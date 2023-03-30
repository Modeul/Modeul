// window.addEventListener("load", function(){
//     var id;
//     var container = document.getElementById('map');
//     var options;
//     function startGeolocation() {
//         if (navigator.geolocation) {
//             id = navigator.geolocation.watchPosition(showGeolocation);
//         }
//     }
//     function showGeolocation(location) {
//         options = {
//             center: new kakao.maps.LatLng(location.coords.latitude, location.coords.longitude),
//             level: 3
//         };
//         var map = new kakao.maps.Map(container, options);
//         var markerPosition = new kakao.maps.LatLng(location.coords.latitude, location.coords.longitude);
//         var marker = new kakao.maps.Marker({
//             position: markerPosition
//         });

//         marker.setMap(map);
//         stopGeolocation();
//     }
//     function stopGeolocation() {
//         if (navigator.geolocation) {
//             navigator.geolocation.clearWatch(id);
//         }
//     }

// });