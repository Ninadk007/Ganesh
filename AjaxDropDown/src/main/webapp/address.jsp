<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function getCountry()
{
    alert("hiii");
    // var s=document.getElementById("t1").value;
    var req = new XMLHttpRequest();   
    // var url = "http://localhost:8092/getcountry/"+username+"/"+password+"";
    req.open("GET","getcountry",true);
    // var url = "getcountry";
    // req.open("GET",url,true);
    // req.open("GET","log?e="+p,true);
    req.send();
    var country = document.getElementById("country");
    req.onreadystatechange=function()
    {
        // alert(req.readyState);
        // alert(req.status);
        if(req.readyState==4 && req.status==200)
        {
            // alert("ninad");
             
            alert(req.responseText);
            var countrylist = JSON.parse(req.responseText);
            // document.getElementById("t2").innerHTML=student.id+" "+student.name+" "+student.username+" "+student.password;
            for(var i=0;i<countrylist.length;i++){
				var op=document.createElement("option");
				op.text=countrylist[i].cname;
				op.value=countrylist[i].cid;
				country.add(op);
				
			}
             
            }
        }
    }

    function getState()
    {
        alert("state function");
        var cid = document.getElementById("country").value;
        var req = new XMLHttpRequest();  
        req.open("GET","getstate?c="+cid,true);
        alert(cid);
        req.send();
        document.getElementById("state").length=0;
        var state = document.getElementById("state");
        req.onreadystatechange=function()
        {
           
            if(req.readyState==4 && req.status==200)
            {
                alert(req.responseText);
                var statelist = JSON.parse(req.responseText);
                for(var i=0;i<statelist.length;i++)
                {
                    var op = document.createElement("option");
                    op.text=statelist[i].sname;
                    op.value=statelist[i].sid;
                    state.add(op);
                }
            }
        }
    }

    function getCity()
    {
        alert("city function");
        var sid = document.getElementById("state").value;
        var req = new XMLHttpRequest();
        req.open("GET","getcity?ct="+sid,true);
        alert(sid);
        req.send();
        document.getElementById("city").length=0;
        var city = document.getElementById("city");
        
        req.onreadystatechange=function()
        {
            
            if(req.readyState==4 & req.status==200)
            {
                alert(req.responseText);
                var citylist = JSON.parse(req.responseText);
                for(var i=0;i<citylist.length;i++)
                {
                    var op = document.createElement("option");
                    op.text=citylist[i].ctname;
                    op.value = citylist[i].ctid;
                    city.add(op);
                }
            }

        }
    }


</script>
</head>
<body onload="getCountry()">
    

Country : <select id="country" onchange="getState()"></select>
State : <select id="state" onchange="getCity()"></select>
        
City : <select id="city"></select>
        




</body>
</html>