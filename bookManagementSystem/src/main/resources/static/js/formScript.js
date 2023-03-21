const nationGenreMapping = {
	한국: ["순정만화", "소년만화", "성인만화", "기획도서", "만화잡지"],
	일본: ["순정만화", "소년만화", "성인만화", "기획도서"],
	미국: ["DC 코믹스마블", "코믹스리터러리", "그래픽노블"],
};

const inputNumber = document.querySelector(".inputNumber");
inputNumber.addEventListener("keyup", function(e) {
	let value = e.target.value;
	value = Number(value.replaceAll(",", ""));
	if (isNaN(value)) {
		inputNumber.value = 0;
	} else {
		const formatValue = value.toLocaleString("ko-KR");
		inputNumber.value = formatValue;
	}
});

//<option value="순정만화" th:selected="'순정만화' == ${bookForm.genre}">순정만화</option>

const nation = document.querySelector(".nation");
const genre = document.querySelector(".genre");
console.log(nation.innerHTML);
nation.addEventListener("change", (event) => {
	const mappedGenre = nationGenreMapping[event.target.value];
	let newHtml = "";
	for (let i = 0; i < mappedGenre.length; i++) {
		//newHtml += `<option value=${mappedGenre[i]}>${mappedGenre[i]}</option>`;
		newHtml += "<option value=" + mappedGenre[i] + " th:selected=" + mappedGenre[i] + "==${bookForm.genre}>" + mappedGenre[i] + "</option>";
	}
	//console.log(newHtml);
	//console.log("<option value=" + mappedGenre[0] + " th:selected=" + mappedGenre[0] + "==${bookForm.genre}>" + mappedGenre[0] + "</option>")
	genre.innerHTML = newHtml;
});

const form = document.querySelector("form");
form.addEventListener("submit", function(event) {
	event.preventDefault();
	event.target.price.value = event.target.price.value.replace(/,/g, "");
	//console.log(event.target.price.value);
	form.submit();
})