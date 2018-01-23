

	
	var passNub=0;
	var failNub=0;
	var sum = 0;

 function frAuthStats_ODC(value){
	
	if(value =="PASS"){
		passNub=passNub+1;
		$("#psNub_ODC").text(passNub);
	}else{
		failNub=failNub+1;
		$("#failNub_ODC").text(failNub);
	}
	$("#sumNub_ODC").text(passNub+failNub);
	return value;
}
 	
 function runTimeSum_ODC(value){
	 
	 if(value !=null){
		 var val= parseFloat(value);
		 sum=sum+val;
		 //alert(sum);
		 $("#runTime_ODC").text(sum.toFixed(3));
		 
	 }
	 return value;
 }
	
	