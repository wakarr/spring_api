function getItem() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/spring_practice/restItemInfo');
	xhr.send();
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4 && xhr.status === 200) {
			var itemList = document.getElementById('itemList');
			var responseData = JSON.parse(xhr.responseText);
			for(var item of responseData) {
				var trTag = document.createElement('tr');
				itemList.appendChild(trTag);
				for(var key in item) {
					if(key != 'category'){
						var tdTag = document.createElement('td');
						tdTag.innerHTML = item[key];
						trTag.appendChild(tdTag);
					} else {
						var tdTag = document.createElement('td');
						tdTag.innerHTML = item[key].name;
						trTag.appendChild(tdTag);
					}
				}
			}
		}
	}
}


function registItem() {
	var id = document.regist.id.value;
	var name = document.regist.name.value;
	var price = document.regist.price.value;
	var categoryId = document.regist.categoryId.value;
	
	var sendData = 'id=' + id + '&name=' + name + '&price=' + price + '&categoryId=' + categoryId;
	
	var xhr = new XMLHttpRequest();
	
	xhr.open('POST', '/spring_practice/restItemInfo');
	xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=UTF-8');
	xhr.send(sendData);
}