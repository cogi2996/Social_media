import { initializeApp } from "https://www.gstatic.com/firebasejs/10.4.0/firebase-app.js";
import {
	getAuth,
	createUserWithEmailAndPassword,

} from "https://www.gstatic.com/firebasejs/10.4.0/firebase-auth.js";

// Your web app's Firebase configuration
const firebaseConfig = {
	apiKey: "AIzaSyAjQ-EW74NHNWM18cww2D5A28ED3_AaKyo",
	authDomain: "strange-song-394808.firebaseapp.com",
	projectId: "strange-song-394808",
	storageBucket: "strange-song-394808.appspot.com",
	messagingSenderId: "1023545526596",
	appId: "1:1023545526596:web:fac90eccaeaa4bdfb16f11",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
// Initialize Firebase Authentication and get a reference to the service
const auth = getAuth(app);

const emailInput = document.getElementById("email");
const NameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const registerButton = document.getElementById("register-button");
const messageDiv = document.getElementById("message");


registerButton.addEventListener("click", () => {
	const email = emailInput.value;
	const password = passwordInput.value;
	const userName = NameInput.value;
	createUserWithEmailAndPassword(auth, email, password)
		.then((userCredential) => {
			userCredential.user.displayName = userName;
			const user = userCredential.user;
			console.log("Đăng ký thành công!", user);
			messageDiv.textContent = "Đăng ký thành công!";
			// Gửi thông tin đăng ký thành công đến máy chủ
			const registrationData = {
				uid: user.uid,
				name: userName,
				email: user.email,
				pass: password,
				// Các thông tin khác bạn muốn gửi
			};
			console.log(registrationData);
			fetch("http://localhost:8080/POST/xulidangky", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(registrationData),
			})
				.then(() => { window.location.href = "http://localhost:8080/POST/dangnhapthanhcong" })

		})

		.catch((error) => {

			const errorMessage = error.message;
			console.error("Lỗi đăng ký:", errorMessage);
			messageDiv.textContent = "Lỗi đăng ký: " + errorMessage;
		});
});
