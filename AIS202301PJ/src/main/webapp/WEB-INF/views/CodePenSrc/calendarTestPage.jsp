<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>
 <!-- https://codepen.io/SaadRegal/pen/ezVBJL -->
 
 <!-- JS Start -->
 <script type="text/javascript">
 
 $(function() {
	 $('#example1').calendar();
	 $('#example2').calendar({
	   type: 'date'
	 });
	 $('#example3').calendar({
	   type: 'time'
	 });
	 $('#rangestart').calendar({
	   type: 'date',
	   endCalendar: $('#rangeend')
	 });
	 $('#rangeend').calendar({
	   type: 'date',
	   startCalendar: $('#rangestart')
	 });
	 $('#example4').calendar({
	   startMode: 'year'
	 });
	 $('#example5').calendar();
	 $('#example6').calendar({
	   ampm: false,
	   type: 'time'
	 });
	 $('#example7').calendar({
	   type: 'month'
	 });
	 $('#example8').calendar({
	   type: 'year'
	 });
	 $('#example9').calendar();
	 $('#example10').calendar({
	   on: 'hover'
	 });
	 var today = new Date();
	 $('#example11').calendar({
	   minDate: new Date(today.getFullYear(), today.getMonth(), today.getDate() - 5),
	   maxDate: new Date(today.getFullYear(), today.getMonth(), today.getDate() + 5)
	 });
	 $('#example12').calendar({
	   monthFirst: false
	 });
	 $('#example13').calendar({
	   monthFirst: false,
	   formatter: {
	     date: function (date, settings) {
	       if (!date) return '';
	       var day = date.getDate();
	       var month = date.getMonth() + 1;
	       var year = date.getFullYear();
	       return day + '/' + month + '/' + year;
	     }
	   }
	 });
	 $('#example14').calendar({
	   inline: true
	 });
	 $('#example15').calendar();
});
 </script>
 
 
 
 <meta charset="utf-8">
 <title>JS Bin</title>
</head>
<body>
  
  <div class="ui container">
  <h1>Calendar examples</h1>
  
  <h3>Input</h3>
  <div class="ui calendar" id="example1">
    <div class="ui input left icon">
      <i class="calendar icon"></i>
      <input type="text" placeholder="Date/Time">
    </div>
  </div>
  <br/>
    
  <h3>Date only</h3>
  <div class="ui calendar" id="example2">
    <div class="ui input left icon">
      <i class="calendar icon"></i>
      <input type="text" placeholder="Date">
    </div>
  </div>
  <br/>
    
  <h3>Time only</h3>
  <div class="ui calendar" id="example3">
    <div class="ui input left icon">
      <i class="time icon"></i>
      <input type="text" placeholder="Time">
    </div>
  </div>
  <br/>
    
  <h3>Range</h3>
  <div class="ui form">
    <div class="two fields">
      <div class="field">
        <label>Start date</label>
        <div class="ui calendar" id="rangestart">
          <div class="ui input left icon">
            <i class="calendar icon"></i>
            <input type="text" placeholder="Start">
          </div>
        </div>
      </div>
      <div class="field">
        <label>End date</label>
        <div class="ui calendar" id="rangeend">
          <div class="ui input left icon">
            <i class="calendar icon"></i>
            <input type="text" placeholder="End">
          </div>
        </div>
      </div>
    </div>
  </div>
  <br/>
  
  <h3>Year first</h3>
  <div class="ui calendar" id="example4">
    <div class="ui input left icon">
      <i class="calendar icon"></i>
      <input type="text" placeholder="Date/Time">
    </div>
  </div>
  <br/>
    
  <h3>Initial value</h3>
  <div class="ui calendar" id="example5">
    <div class="ui input left icon">
      <i class="calendar icon"></i>
      <input type="text" placeholder="Date" value="5/30/2015 3pm">
    </div>
  </div>
  <br/>
    
  <h3>24-hour</h3>
  <div class="ui calendar" id="example6">
    <div class="ui input left icon">
      <i class="time icon"></i>
      <input type="text" placeholder="Time">
    </div>
  </div>
  <br/>
    
  <h3>Month and year</h3>
  <div class="ui calendar" id="example7">
    <div class="ui input left icon">
      <i class="time icon"></i>
      <input type="text" placeholder="Time">
    </div>
  </div>
  <br/>
    
  <h3>Year only</h3>
  <div class="ui calendar" id="example8">
    <div class="ui input left icon">
      <i class="time icon"></i>
      <input type="text" placeholder="Time">
    </div>
  </div>
  <br/>
  
  <h3>Button</h3>
  <div class="ui calendar" id="example9">
    <div class="ui button">Select date</div>
  </div>
  <br/>
  
  <h3>Hover</h3>
  <div class="ui calendar" id="example10">
    <div class="ui button">Hover me</div>
  </div>
  <br/>
  
  <h3>Min/Max date</h3>
  <div class="ui calendar" id="example11">
    <div class="ui input">
      <input type="text" placeholder="Date">
    </div>
  </div>
  <br/>
  
  <h3>Day first</h3>
  <div class="ui calendar" id="example12">
    <div class="ui input">
      <input type="text" placeholder="Date">
    </div>
  </div>
  <br/>
  
  <h3>Custom format</h3>
  <div class="ui calendar" id="example13">
    <div class="ui input">
      <input type="text" placeholder="Date">
    </div>
  </div>
  <br/>
  
  <h3>Inline</h3>
  <div class="ui calendar" id="example14">
  </div>
  <br/>
  
  <h3>Implicit inline (no popup activator)</h3>
  <div class="ui calendar" id="example15">
  </div>
  <br/>
    
  </div>
</body>
</html>