"use strict";

const id = document.getElementById("id"),
  name = document.getElementById("name"),
  psword = document.getElementById("psword"),
  confirmPsword = document.getElementById("confirm-psword"),
  registerBtn = document.getElementById("registerbtn");

  registerBtn.addEventListener('click', register);

  function register() {
    if (!id.value) return alert("아이디를 입력해주세요.");
    if (psword.value !== confirmPsword.value) return alert("비밀번호가 일치하지 않습니다.");
    

    const req = {
      id: id.value,
      name: name.value,
      psword: psword.value,
    };

    console.log("이정표",req);

    fetch("/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(req)
    })
    .then((res) => res.json())
    .then((res) => {
      if (res.success) {
        location.href = "/login";
      } else {
        alert(res.msg);
      }
    })
    .catch((err) => {
      console.error("회원가입 중 에러발생");
    });
  }