"use strict";

const id = document.getElementById("id"),
  psword = document.getElementById("psword"),
  loginBtn = document.getElementById("loginbtn");

  console.log(id,psword,loginBtn);

  loginBtn.addEventListener('click', login);

  function login() {
    const req = {
      id: id.value,
      psword: psword.value,
    };

    fetch("/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(req)
    })
    .then((res) => res.json())
    .then((res) => {
      if (res.success) {
        location.href = "/";
      } else {
        alert(res.msg);
      }
    })
    .catch((err) => {
      console.error("로그인 중 에러발생");
    });
  }