//
//$(document).ready(function() {
//	
// $(".num").click(function(){
//	 var $input = $("#qty");
//    if ($(this).hasClass("plus")) {
//        $input.val(parseInt($input.val())+1);     
//        updateLabel($input.val());
//    }    
//    else if ($input.val()>=1) {
//        $input.val(parseInt($input.val())-1);
//        updateLabel($input.val());
//    }
//  });
//});
//
//function updateLabel(input) {
//	var price = document.getElementById("price_label1").value;
//	var price_label = document.getElementById("price_label22");
//	//price_label.innerHTML = "$dsfasda" +(price * input);
//	price_label.value = "$"+(price * input);		
//}


function increment(form,label)
{
  
	var price = parseInt(form.price.value);
	
	var quantity = parseInt(form.quantity.value) + 1;
	
    var calculatedValue = (price * quantity);
	
	var currentCartTotal = parseInt(document.getElementById("cart_total").value);
	var currentOrderTotal = parseInt(document.getElementById("order_total").value);
	
	//alert("Current Order Total "+currentOrderTotal);
	
	currentCartTotal = currentCartTotal + price;
	currentOrderTotal = currentOrderTotal + price;
	
	document.getElementById("cart_total_label").innerHTML = "$ "+currentCartTotal.toFixed(2);
	document.getElementById("order_total_label").innerHTML = "$ "+currentOrderTotal.toFixed(2);
	
	
	document.getElementById("cart_total").value = currentCartTotal;
	document.getElementById("order_total").value = currentOrderTotal;
	
	label.innerHTML = "$ "+calculatedValue.toFixed(2);
	//alert(label.innerHTML);

    form.quantity.value = quantity;
    
}



function decrement(form,label)
{
	var price = parseInt(form.price.value);
	//var quantity = parseInt(form.quantity.value) - 1;
	var quantity = parseInt(form.quantity.value);
	
	if(quantity >= 1) {
		
		quantity = parseInt(form.quantity.value) - 1
		var calculatedValue = (price * quantity);
		
		var currentCartTotal = parseInt(document.getElementById("cart_total").value);
		var currentOrderTotal = parseInt(document.getElementById("order_total").value);
		
		
		currentCartTotal = currentCartTotal - price;
		
		currentOrderTotal = currentOrderTotal - price;
		document.getElementById("cart_total_label").innerHTML = "$ "+currentCartTotal.toFixed(2);
		document.getElementById("order_total_label").innerHTML = "$ "+currentOrderTotal.toFixed(2);
		
		document.getElementById("cart_total").value = currentCartTotal;
		document.getElementById("order_total").value = currentOrderTotal;
		
		label.innerHTML = "$ "+calculatedValue.toFixed(2);
		//alert(label.innerHTML);
		
	    form.quantity.value = quantity;
	     
	}
	
	
}
