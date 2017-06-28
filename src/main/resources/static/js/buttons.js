
$(document).ready(function() {

	var $input = $("#qty")

 $(".num").click(function(){
    if ($(this).hasClass("plus")) {
        $input.val(parseInt($input.val())+1); 
        // call update cartTotal price
        //updatePrice();
    }    
    else if ($input.val()>=1) {
        $input.val(parseInt($input.val())-1);
    }
  });
});

// Create function to update price

/*function updatePrice(price,quantity,price_label) {	
	/*var cartTotal = document.getElementById("cart_total").value;
	cartTotal = (cartTotal * $input.val());	
	
	var cartTotal = document.getElementById("cart_total").value;
    var orderTotal = document.getElementById("order_total").value;
    
    var totalPrice = parseFloat(price) * parseFloat(quantity);
    
    price_label.innerHTML = "$"+totalPrice;
    
    cTotal  = parseFloat(cartTotal) + parseFloat(price);
    
    oTotal = parseFloat(orderTotal) + parseFloat(price);
    
    document.getElementById("cart_total_label").innerHTML = "$"+cTotal;
    
    document.getElementById("order_total_label").innerHTML = "$"+oTotal;
    
}*/	
