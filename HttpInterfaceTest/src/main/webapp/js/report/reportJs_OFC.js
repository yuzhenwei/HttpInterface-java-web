

	
	var passNub=0;
	var failNub=0;
	var sum = 0;

 function frAuthStats_OFC(value){
	
	if(value =="PASS"){
		passNub=passNub+1;
		$("#psNub_OFC").text(passNub);
	}else{
		failNub=failNub+1;
		$("#failNub_OFC").text(failNub);
	}
	$("#sumNub_OFC").text(passNub+failNub);
	return value;
}
 	
 function runTimeSum_OFC(value){
	 
	 if(value !=null){
		 var val= parseFloat(value);
		 sum=sum+val;
		 //alert(sum);
		 $("#runTime_OFC").text(sum.toFixed(3));
		 
	 }
	 return value;
 }
	
	