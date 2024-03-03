var toggle = true;

$(".sidebar-icon").click(function () {
    if (toggle) {
        $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
        $("#menu span").css({"position": "absolute"});
    } else {
        $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
        setTimeout(function () {
            $("#menu span").css({"position": "relative"});
        }, 400);
    }

    toggle = !toggle;
});

//images print
function frontview(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#one')
                .attr('src', e.target.result)

        };

        reader.readAsDataURL(input.files[0]);
    }
}

function fontview(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#two')
                .attr('src', e.target.result)

        };

        reader.readAsDataURL(input.files[0]);
    }
}

function frontview1(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#one1')
                .attr('src', e.target.result)

        };

        reader.readAsDataURL(input.files[0]);
    }
}

function fntview(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#three')
                .attr('src', e.target.result)

        };

        reader.readAsDataURL(input.files[0]);
    }
}

function ftview(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#four')
                .attr('src', e.target.result)

        };

        reader.readAsDataURL(input.files[0]);
    }
}

function copy() {
    var selectBox = document.getElementById('area');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    var select = document.getElementById('mapsearch');
    select.value = userInput;
}

//thumniul caption
$(document).ready(function () {

    $(function () {
        $('.mm_tooltip').tooltip({
            selector: "[data-toggle=tooltip]",
            container: "body"
        })
    });

    $('.thumbnail').hover(
        function () {
            $(this).find('.caption').slideDown(300); //.fadeIn(250)
        },
        function () {
            $(this).find('.caption').slideUp(200); //.fadeOut(205)
        }
    );

    $('#btndel').on('click', function () {
        alert('Are you sure you want to delete');

    });

});

/*


var map = new google.maps.Map(document.getElementById('map'), {
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
var searchBox = new google.maps.places.SearchBox(document.getElementById('mapsearch'));
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
                $('#maplat').val(marker.getPosition().lat());
                $('#maplong').val(marker.getPosition().lng());
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
var marker = new google.maps.Marker({
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
                $('#maplat1').val(marker.getPosition().lat());
                $('#maplong1').val(marker.getPosition().lng());
                $('#mapsearch1').val(results[0].formatted_address);

                infowindow.setContent(results[0].formatted_address);
                google.maps.event.trigger(map, 'resize');
                infowindow.open(map, marker);
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
*/


$('#radioBtn a').on('click', function () {
    var sel = $(this).data('title');
    var tog = $(this).data('toggle');
    $('#' + tog).prop('value', sel);

    $('a[data-toggle="' + tog + '"]').not('[data-title="' + sel + '"]').removeClass('active').addClass('notActive');
    $('a[data-toggle="' + tog + '"][data-title="' + sel + '"]').removeClass('notActive').addClass('active');
})
