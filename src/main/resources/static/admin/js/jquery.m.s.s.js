$(function () {
	var solutionBank = "http://45.114.233.50:8080";
	//var solutionBank = "http://45.114.233.50:8080/Solution";
	
	var themeBank = "http://45.114.233.50:8080/Openmarket";
	var themePreview = "http://45.114.233.50:8080/preview";
	
	var codeBank = "http://45.114.233.50:8080/Codemarket";
	var codePreview = "http://45.114.233.50:8080/preview";
	
	var _3dBank = "http://45.114.233.50:8080/3dmarket";
	var _3dPreview = "http://45.114.233.50:8080/preview";
	
	var graphicsBank = "http://45.114.233.50:8080/Openmarket";
	var themeBank = "http://45.114.233.50:8080/Openmarket";
	var themeBank = "http://45.114.233.50:8080/Openmarket";
	
	$(document).on("click", "button.check-staction", function(e){
		e.preventDefault();
		$("div.main-waiter-container").show(1);
		$("h4#wait-msg").html("Changing theme status..... please wait...");
		
		var item_id = $(this).data("id");
		var _url = solutionBank + $("form#form-"+item_id).attr("action");
		var ps = $("select#"+item_id).val();
		$.ajax({
            url: _url,
            type: 'POST',
            dataType: "text",
            data: {"productStatus": ps},
            success: function(msg){
                //alert(JSON.stringify(msg));
            	$("h4#wait-msg").html("Coping theme to preview directory..... don't close the window...");
            	changeStatusOfTheUploadedTheme(item_id);
                //$("div.main-waiter-container").hide(1);
            },
            error: function(err){
            	alert(JSON.stringify(err));
                //$("div.main-waiter-container").hide(1);
            }
        });
	});
	
	function changeStatusOfTheUploadedTheme(item_id){
		$.ajax({
            url: themeBank + "/Items/digital/copy_to_demo_views/test.html",
            type: 'POST',
            dataType: "text",
            data: {"itemId": item_id},
            success: function(msg){
                //alert(JSON.stringify(msg));
            	$("h4#wait-msg").html("Sending preview data to manager..... hold on...");
                manageUploadedFileForUserPreview(msg);
                //$("div.main-waiter-container").hide(1);
            },
            error: function(err){
            	alert(JSON.stringify(err));
                //$("div.main-waiter-container").hide(1);
            }
        });
	}
	
	function manageUploadedFileForUserPreview(item){
		var itemData = item.split("#");
		$.ajax({
            url: themePreview + "/item/add_to_preview",
            type: 'POST',
            dataType: "text",
            data: {"project_id": itemData[0], "name": itemData[1], "folder_name":itemData[2], "status":itemData[3] },
            success: function(msg){
                $("h4#wait-msg").html("Updating preview url..... hold on...");
                updatePreviewUrlPreview(itemData[0], itemData[2]);
            },
            error: function(err){
            	alert(JSON.stringify(err));
                //$("div.main-waiter-container").hide(1);
            }
        });
	}
    
    function updatePreviewUrlPreview(id, folder_name){
		$.ajax({
            url: solutionBank + "/Solution/Admin/theme/digitalItems/edit_preview_url/" + id,
            type: 'POST',
            dataType: "text",
            data: {"slug": folder_name},
            success: function(msg){
                alert(JSON.stringify("Job Successfully Done"));
                $("div.main-waiter-container").hide(1200);
            },
            error: function(err){
            	alert(JSON.stringify(err));
                $("div.main-waiter-container").hide(1);
            }
        });
	}
});