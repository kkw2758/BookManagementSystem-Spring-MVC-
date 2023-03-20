var slides = document.querySelector(".slides"),
  slide = document.querySelectorAll(".slides li"),
  currentIdx = 0,
  slideCount = slide.length,
  slideWidth = 180,
  slideMargin = 25,
  prevBtn = document.querySelector(".left"),
  nextBtn = document.querySelector(".right");

makeClone();

function makeClone() {
  for (var i = 0; i < slideCount; i++) {
    // a.cloneNode() a요소 그대로 복사
    // a.cloneNode(true) a의 자식요소 까지 모두 복사
    var cloneSlide = slide[i].cloneNode(true);
    cloneSlide.classList.add("clone");
    // a.appenChild(b)
    slides.appendChild(cloneSlide);
  }
  for (var i = slideCount - 1; i >= 0; i--) {
    var cloneSlide = slide[i].cloneNode(true);
    cloneSlide.classList.add("clone");
    // a.prepend(b) 요소의 앞에 추가
    slides.prepend(cloneSlide);
  }
  updateWidth();
  setInitialPos();
  setTimeout(function () {
    slides.classList.add("animated");
  }, 100);
}

function updateWidth() {
  var currentSlide = document.querySelectorAll(".slides li");
  var newSlideCount = currentSlide.length;
  var newWidth =
    (slideWidth + slideMargin) * newSlideCount - slideMargin + "px";
  slides.style.width = newWidth;
}
// translate는 기본 포지션
// left는 슬라이드 이동
function setInitialPos() {
  console.log(slideCount);
  console.log(slideWidth, slideMargin);
  var initalTranslateValue =
    -(slideWidth + slideMargin) * slideCount + slideMargin + "px";
  // slides { transform:translateX(-1000px);}
  slides.style.transform = `translateX(${initalTranslateValue})`;
}

nextBtn.addEventListener("click", function () {
  moveSlide(currentIdx + 1);
});

prevBtn.addEventListener("click", function () {
  moveSlide(currentIdx - 1);
});

function moveSlide(num) {
  slides.style.left = -num * (slideWidth + slideMargin) + "px";
  currentIdx = num;
  console.log(currentIdx, slideCount);

  if (currentIdx == slideCount || currentIdx == -slideCount) {
    setTimeout(function () {
      slides.classList.remove("animated");
      slides.style.left = "0px";
      currentIdx = 0;
    }, 500);
    setTimeout(function () {
      slides.classList.add("animated");
    }, 600);
  }
}

// 드래그(스와이프) 이벤트를 위한 변수 초기화
let startPoint = 0;
let endPoint = 0;

// PC 클릭 이벤트 (드래그)
slides.addEventListener("mousedown", (e) => {
  startPoint = e.pageX; // 마우스 드래그 시작 위치 저장
});

slides.addEventListener("mouseup", (e) => {
  endPoint = e.pageX; // 마우스 드래그 끝 위치 저장
  if (startPoint < endPoint) {
    // 마우스가 오른쪽으로 드래그 된 경우
    moveSlide(currentIdx - 1);
  } else if (startPoint > endPoint) {
    // 마우스가 왼쪽으로 드래그 된 경우
    moveSlide(currentIdx + 1);
  }
});


// 기본적으로 슬라이드 루프 시작하기
let loopInterval = setInterval(() => {
  moveSlide(currentIdx + 1);
}, 3000);

// 슬라이드에 마우스가 올라간 경우 루프 멈추기
slides.addEventListener("mouseover", () => {
  clearInterval(loopInterval);
});

// 슬라이드에서 마우스가 나온 경우 루프 재시작하기
slides.addEventListener("mouseout", () => {
  loopInterval = setInterval(() => {
    moveSlide(currentIdx + 1);
  }, 3000);
});

prevBtn.addEventListener("mouseover", () => {
  clearInterval(loopInterval);
});

prevBtn.addEventListener("mouseout", () => {
  loopInterval = setInterval(() => {
    moveSlide(currentIdx + 1);
  }, 3000);
});

nextBtn.addEventListener("mouseover", () => {
  clearInterval(loopInterval);
});

nextBtn.addEventListener("mouseout", () => {
  loopInterval = setInterval(() => {
    moveSlide(currentIdx + 1);
  }, 3000);
});
