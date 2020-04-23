
function callback(req, logic) {
	return function () {
     // If the request's status is "complete"
		if (req.readyState == 4) {
       
       // Check that we received a successful response from the server
			if (req.status == 200) {

         // Pass the XML payload of the response to the handler function.
				logic(req.responseText);
			} else {

         // An HTTP problem has occurred
				alert("HTTP error " + req.status + ": " + req.statusText);
			}
		}
	};
}
function send_request(method, url, content, responseType, logic) {
	var http_request = newXMLHttpRequest();
	if (responseType.toLowerCase() == "text" || responseType.toLowerCase() == "xml") {
		http_request.onreadystatechange = callback(http_request, logic);
	} else {
		window.alert("????????????");
		return false;
	}
	if (method.toLowerCase() == "get") {
		http_request.open(method, url, true);
	} else {
		if (method.toLowerCase() == "post") {
			http_request.open(method, url, true);
			http_request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		} else {
			window.alert("http????????????");
			return false;
		}
	}
	http_request.send(content);
}
function getAgency(obj) {
	send_request("post", "show_agencyinfo.jsp", "agency=" + obj, "text", update);
}
function enterAgency(obj) {
	drs("loading...");
	getAgency(obj);
}
function update(cartXML) {
	var over = document.getElementById("overDiv");
	var temp = cartXML.split("||");
	var name = temp[0];
	var description = temp[1];
	var telephone = temp[2];
	var address = temp[3];
	over.innerHTML = "<div class='text pop' style=''>" + name + "<br>" + description + "<br>" + telephone + "<br>" + address + "<br></div>";
}
function newXMLHttpRequest() {
	var xmlreq = false;

  // Create XMLHttpRequest object in non-Microsoft browsers
	if (window.XMLHttpRequest) {
		xmlreq = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			try {
      // Try to create XMLHttpRequest in later versions
      // of Internet Explorer
				xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e1) {

      // Failed to create required ActiveXObject
				try {
        // Try version supported by older versions
        // of Internet Explorer
					xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e2) {

        // Unable to create an XMLHttpRequest by any means
					xmlreq = false;
				}
			}
		}
	}
	return xmlreq;
}
function suggest(id) {
	send_request("post", "suggest.jsp", "id=" + id, "text", submitSuggest);
}
function submitSuggest(text) {
	temp = text.split("||");
}
function sendMessage() {
	send_request("post", "returnMessage.html?method=returnMessage", null, "text", show);
}
function show(text) {
	var texts = text.split("**");
}
function sendBI(choose) {
	var select1 = choose.value;
	send_request("post", "getType.html?method=getSubIndustry", "basicIndustry=" + select1, "text", setSI);
}
function setSI(text) {
	var texts = text.split("|*|");

	var select4 = document.getElementById("select4");
	if(select4!=null){
	var l = select4.options.length;
	for (var i = l; i > 0; i = i - 1) {
		select4.remove(i);
	}
	}
	var select3 = document.getElementById("select3");

	if(select3!=null){
	var l = select3.options.length;
	for (var i = l; i > 0; i = i - 1) {
		select3.remove(i);
	}

	
	for (var i = 1; i < texts.length - 1; i = i + 1) {
		var o = new Option();
		o.value = texts[i];
		o.text = texts[i];
		select3.add(o);
	}
	}
	
	texts = texts[0].split("**");
	var select2 = document.getElementById("select2");
	if(select2!=null){
			
	var l = select2.options.length;
	for (var i = l; i > 0; i = i - 1) {
		select2.remove(i);
	}
	for (var j = 1; j < texts.length; j = j + 1) {
		var o = new Option();
		o.value = texts[j];
		o.text = texts[j];
		select2.add(o);
	}
	}
}
function sendDM(choose) {
	var select3 = choose.value;
	send_request("post", "getType.html?method=getSubDevice", "major=" + select3, "text", setDM);
}
function setDM(text) {
	var texts = text.split("**");
	var select4 = document.getElementById("select4");
	var l = select4.options.length;
	for (var i = l; i > 0; i = i - 1) {
		select4.remove(i);
	}
	for (var i = 1; i < texts.length - 1; i = i + 1) {
		var o = new Option();
		o.value = texts[i];
		o.text = texts[i];
		select4.add(o);
	}
}

function sendDomain(domain) {
	
	send_request("post", "getType.html?method=getSubType", "basicIndustry=" + domain, "text", setSubType);
}

function sendDomain2(domain) {
    send_request("post", "getType.html?method=getBuildUnit", "basicIndustry=" + domain, "text", setBuildUnit);
}

function setSubType(text){
    var texts = text.split("**");
    var subtype = document.getElementById("subtype");
    var l = subtype.options.length;
    for (var i = l; i >= 0; i = i - 1) {
		subtype.remove(i);
	}
	for (var i = 1; i < texts.length - 1; i = i + 1) {
		var o = new Option();
		o.value = texts[i];
		o.text = texts[i];
		subtype.add(o);
	}
}

function setMajor(text){
    var texts = text.split("**");
    var specialty = document.getElementById("specialty");
    var l = specialty.options.length;
    for (var i = l; i >= 0; i = i - 1) {
		specialty.remove(i);
	}
	for (var i = 1; i < texts.length - 1; i = i + 1) {
		var o = new Option();
		o.value = texts[i];
		o.text = texts[i];
		specialty.add(o);
	}
	var temp = texts[1];
	sendMajor2(temp);
	
}


function sendMajor2(obj){
   
    send_request("post", "getType.html?method=getSubDevice", "major=" + obj, "text", setSubType);
}

function setBuildUnit(text) {
    var texts=text.split("**");
    if(texts.length != 0 && texts[0] != "") {
        var buildunit = document.getElementById("buildunit");
	    var length = buildunit.options.length;
	    for (var i = length; i >=0; i = i - 1) {
	        buildunit.remove(i);
	    }
	    
	    for (var i = 1; i < texts.length - 1; i = i + 1) {
	        var o = new Option();
	        o.value = texts[i];
	        o.text = texts[i];
	        buildunit.add(o);
        }
    }else if(texts.length == 2){
    	var input = document.getElementById("test");
    	input.innerHTML="<input value='         '></input>";
    }
}

function sendMajor(obj){
    var major=obj.value;
    send_request("post", "getType.html?method=getSubDevice", "major=" + major, "text", setSubType);
}

function sendProject(projectid,domain){
    send_request("post", "contracts.html?method=getBatch", "projectid=" + projectid+"&&domain="+domain, "text", setBatch);
    send_request("post", "contracts.html?method=getMajors", "projectid=" + projectid, "text", setMajor);
}

function setBatch(text){

  var texts=text.split("**");
  var batch=$("parentbatch");
  var l = batch.options.length;
    //for (var i = l; i > 0; i = i - 1) {
	//	batch.remove(i);
	//}
	for (var i = 1; i < texts.length - 1; i = i + 1) {
		var o = new Option();
		o.value = i;
		o.text =texts[i];
		batch.add(o);
	}
  
}

function sendSupplierName(obj){
    var text=$("name").value;
    if(text.length>1){
        send_request("post", "suppliers.html?method=getNames", "name=" + text, "text", setNames);
    }
}

function sendClientName(obj){
    var text=$("name").value;
    if(text.length>1){
        send_request("post", "clients.html?method=getNames", "name=" + text, "text", setNames);
    }
}

function setNames(text){
    var texts=text.split("**");
    var inner="";
    var names=$("names");
    for(var i=1;i<texts.length-1;i=i+1){
        inner=inner+texts[i]+"<br/>";
    }
    names.innerHTML=inner;
}

function addBatch(projectId){
    
    send_request("post", "contracts.html?method=addBatch", "projectId=" + projectId, "text", setBatches);
}

function setBatches(text){
    var texts=text.split("**");
    var list=$("list");
    
    var inner="";
     for(var i=1;i<texts.length-1;i=i+1){
        inner=inner+" "+texts[i];
    }
    list.innerHTML=inner;
}




