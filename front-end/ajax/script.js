window.onload = function () {
  var httpRequest;
  const searchBtn = document.querySelector(".searchBtn");
  const keyword = document.querySelector("#keyword");
  searchBtn.addEventListener("click", () => {
    if (keyword.value.length < 2) {
      alert("두글자 이상 입력해주세요.");
    } else {
      httpRequest = new XMLHttpRequest();
      httpRequest.onreadystatechange = () => {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
          if (httpRequest.status === 200) {
            var result = httpRequest.response;
            console.log(result);
            //   document.getElementById("name").innerText = result.name;
            //   document.getElementById("age").innerText = result.age;
          } else {
            alert("Request Error!");
          }
        }
      };

      /* Get 방식으로 name 파라미터와 함께 요청 */
      httpRequest.open(
        "POST",
        "/list?nation=일본&genre=기획도서&option=title&keyword=헌신"
      );
      /* Response Type을 Json으로 사전 정의 */
      httpRequest.responseType = "json";
      /* 정의된 서버에 요청을 전송 */
      httpRequest.send();
    }
  });
};
