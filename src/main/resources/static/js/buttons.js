
$(document).ready(function() {
	
 $(".num").click(function(){
	 var $input = $("#qty");
    if ($(this).hasClass("plus")) {
        $input.val(parseInt($input.val())+1);     
        updateLabel($input.val());
    }    
    else if ($input.val()>=1) {
        $input.val(parseInt($input.val())-1);
        updateLabel($input.val());
    }
  });
});






function updateLabel(input) {
	var price = document.getElementById("price_label1").value;
	var price_label = document.getElementById("price_label22");
	//price_label.innerHTML = "$dsfasda" +(price * input);
	price_label.value = "$"+(price * input);		
}
