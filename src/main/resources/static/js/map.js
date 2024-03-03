
var map = new google.maps.Map(document.getElementById('map'), {
    center: {
        lat: 25.286106,
        lng: 51.534817
    },
    zoom: 15
});
var marker1 = new google.maps.Marker({
    position: {
        lat: 25.286106,
        lng: 51.534817
    },
    map: map,

    draggable: true
});
var searchBox = new google.maps.places.SearchBox(document.getElementById('mapsearch'));
google.maps.event.addListener(searchBox, 'places_changed', function () {
    var places = searchBox.getPlaces();
    var bounds = new google.maps.LatLngBounds();
    var i, place;

    for (i = 0; place = places[i]; i++) {
        //console.long(place.geometry.location);
        bounds.extend(place.geometry.location);
        marker1.setPosition(place.geometry.location);

    }

    map.fitBounds(bounds);
    map.setZoom(15);

});


var geocoder = new google.maps.Geocoder();

google.maps.event.addListener(marker1, 'dragend', function () {

    geocoder.geocode({'latLng': marker1.getPosition()}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {
                $('#maplat').val(marker1.getPosition().lat());
                $('#maplong').val(marker1.getPosition().lng());
                $('#mapsearch').val(results[0].formatted_address);

                infowindow.setContent(results[0].formatted_address);
                google.maps.event.trigger(map, 'resize');
                infowindow.open(map, marker);
            }
        }
    });
});


var map = new google.maps.Map(document.getElementById('map1'), {
    center: {
        lat: 25.286106,
        lng: 51.534817
    },
    zoom: 15
});
var marker2 = new google.maps.Marker({
    position: {
        lat: 25.286106,
        lng: 51.534817
    },
    map: map,

    draggable: true
});
var searchBox = new google.maps.places.SearchBox(document.getElementById('mapsearch1'));
google.maps.event.addListener(searchBox, 'places_changed', function () {
    var places = searchBox.getPlaces();
    var bounds = new google.maps.LatLngBounds();
    var i, place;

    for (i = 0; place = places[i]; i++) {
        //console.long(place.geometry.location);
        bounds.extend(place.geometry.location);
        marker2.setPosition(place.geometry.location);

    }

    map.fitBounds(bounds);
    map.setZoom(15);

});


var geocoder = new google.maps.Geocoder();

google.maps.event.addListener(marker2, 'dragend', function () {

    geocoder.geocode({'latLng': marker2.getPosition()}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {
                $('#maplat1').val(marker2.getPosition().lat());
                $('#maplong1').val(marker2.getPosition().lng());
                $('#mapsearch1').val(results[0].formatted_address);

                infowindow.setContent(results[0].formatted_address);
                google.maps.event.trigger(map, 'resize');
                infowindow.open(map, marker2);
            }
        }
    });
});








var map = new google.maps.Map(document.getElementById('map2'), {
    center: {
        lat: 25.286106,
        lng: 51.534817
    },
    zoom: 15
});
var marker = new google.maps.Marker({
    position: {
        lat: 25.286106,
        lng: 51.534817
    },
    map: map,

    draggable: true
});
var searchBox = new google.maps.places.SearchBox(document.getElementById('mapsearch2'));
google.maps.event.addListener(searchBox, 'places_changed', function () {
    var places = searchBox.getPlaces();
    var bounds = new google.maps.LatLngBounds();
    var i, place;

    for (i = 0; place = places[i]; i++) {
        //console.long(place.geometry.location);
        bounds.extend(place.geometry.location);
        marker.setPosition(place.geometry.location);

    }

    map.fitBounds(bounds);
    map.setZoom(15);

});


var geocoder = new google.maps.Geocoder();

google.maps.event.addListener(marker, 'dragend', function () {

    geocoder.geocode({'latLng': marker.getPosition()}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {
                $('#maplat2').val(marker.getPosition().lat());
                $('#maplong2').val(marker.getPosition().lng());
                $('#mapsearch2').val(results[0].formatted_address);

                infowindow.setContent(results[0].formatted_address);
                google.maps.event.trigger(map, 'resize');
                infowindow.open(map, marker);
            }
        }
    });
});





/*

var map = new google.maps.Map(document.getElementById('map3'), {
    center: {
        lat: 25.286106,
        lng: 51.534817
    },
    zoom: 15
});
var marker4 = new google.maps.Marker({
    position: {
        lat: 25.286106,
        lng: 51.534817
    },
    map: map,

    draggable: true
});

var searchBox = new google.maps.places.SearchBox(document.getElementById('mapsearch2'));
google.maps.event.addListener(searchBox, 'places_changed', function () {
    var places = searchBox.getPlaces();
    var bounds = new google.maps.LatLngBounds();
    var i, place;

    for (i = 0; place = places[i]; i++) {
        //console.long(place.geometry.location);
        bounds.extend(place.geometry.location);
        marker4.setPosition(place.geometry.location);

    }

    map.fitBounds(bounds);
    map.setZoom(15);

});


var geocoder = new google.maps.Geocoder();

google.maps.event.addListener(marker4, 'dragend', function () {

    geocoder.geocode({'latLng': marker4.getPosition()}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {
                $('#maplat2').val(marker4.getPosition().lat());
                $('#maplong2').val(marker4.getPosition().lng());
                $('#mapsearch2').val(results[0].formatted_address);

                infowindow.setContent(results[0].formatted_address);
                google.maps.event.trigger(map, 'resize');
                infowindow.open(map, marker4);
            }
        }
    });
});
*/


