

	
	var passNub=0;
	var failNub=0;
	var sum = 0;

 function frAuthStats(value){
	
	if(value =="PASS"){
		passNub=passNub+1;
		$("#psNub").text(passNub);
	}else{
		failNub=failNub+1;
		$("#failNub").text(failNub);
	}
	$("#sumNub").text(passNub+failNub);
	return value;
}
 	
 function runTimeSum(value){
	 
	 if(value !=null){
		 var val= parseFloat(value);
		 sum=sum+val;
		 //alert(sum);
		 $("#runTime").text(sum.toFixed(3));
		 
	 }
	 return value;
 }
	
	