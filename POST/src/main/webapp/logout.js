import { initializeApp } from "https://www.gstatic.com/firebasejs/10.4.0/firebase-app.js";
import {
	getAuth,
	signOut,
	onAuthStateChanged,

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
const logoutButton = document.getElementById("logout-button");
const messageDiv = document.getElementById("message");
onAuthStateChanged(auth, (user) => {
	if (user) {
		// User is signed in, see docs for a list of available properties
		// https://firebase.google.com/docs/reference/js/auth.user
		const uid = user.uid;
		console.log("uid current user: " + uid);
		// ...
	} else {
		// User is signed out
		console.log("No one here");
		// ...
	}
});
const user = auth.currentUser;
if (user) {

	console.log(user.email);
}
else {
	console.log("No one log in");
}
logoutButton.addEventListener("click", () => {
	// Đăng xuất người dùng
	signOut(auth)
		.then(() => {
			/*console.log(localStorage.getItem("idToken"));*/
			console.log("Đăng xuất thành công");

			// Sign-out successful
			messageDiv.textContent = "Đăng xuất thành công!";
		})
		.then(
			// HTTP GET --> log out session từ server
			fetch("http://localhost:8080/POST/xulidangxuat", { method: "GET", })
		)
		.then(() => {
			window.location.href = "http://localhost:8080/POST/login.jsp";
		}

		)
		.catch((error) => {
			// An error happened.

		});

	// Hiển thị thông báo đăng xuất
});