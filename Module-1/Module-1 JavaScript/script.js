let formChanged = false;

console.log("Local Community Event Portal Loaded Successfully");

/* Registration */

function submitRegistration(event) {
  event.preventDefault();

  console.log("Registration Form Submitted");

  let selectedEvent = document.getElementById("eventType").value;

  console.log("Selected Event:", selectedEvent);

  document.getElementById("msg").innerText =
    "Registration submitted successfully!";

  formChanged = false;
}

/* Phone Validation */

function validatePhone() {
  let phone = document.getElementById("phone").value;

  console.log("Phone Entered:", phone);

  if (phone.length != 10 || isNaN(phone)) {
    console.log("Invalid Phone Number");

    document.getElementById("phoneMsg").innerText =
      "Please enter a valid 10-digit phone number.";

    document.getElementById("phoneMsg").style.color = "red";
  } else {
    console.log("Valid Phone Number");

    document.getElementById("phoneMsg").innerText = "Valid phone number";

    document.getElementById("phoneMsg").style.color = "green";
  }
}

/* Event Fee */

function showFee() {
  let fee = document.getElementById("eventSelect").value;

  console.log("Selected Fee:", fee);

  if (fee !== "") {
    document.getElementById("feeDisplay").innerText =
      "Registration Fee: ₹" + fee;

    document.getElementById("feeDisplay").style.color = "#00695c";
  } else {
    document.getElementById("feeDisplay").innerText = "";
  }
}

/* Feedback */

function submitFeedback() {
  console.log("Feedback Submitted");

  document.getElementById("confirmMsg").innerText =
    "Feedback submitted successfully!";
}

/* Image Enlarge */

function enlargeImage() {
  console.log("Image Double Clicked");

  let img = document.getElementById("eventImg");

  if (img.style.width === "400px") {
    img.style.width = "250px";

    console.log("Image Reduced");
  } else {
    img.style.width = "400px";

    console.log("Image Enlarged");
  }
}

/* Character Counter */

function countCharacters() {
  let text = document.getElementById("feedbackText").value;

  console.log("Character Count:", text.length);

  document.getElementById("charCount").innerText = text.length;
}

/* Video Ready */

function videoReady() {
  console.log("Video Ready to Play");

  document.getElementById("videoMessage").innerText = "Video is ready to play!";
}

/* Save User Preference */

function savePreference() {
  let selectedEvent = document.getElementById("eventType").value;

  console.log("Saving Preference:", selectedEvent);

  localStorage.setItem("preferredEvent", selectedEvent);

  sessionStorage.setItem("sessionEvent", selectedEvent);
}

/* Load Saved Preference */

window.onload = function () {
  console.log("Loading Saved Preferences");

  let savedEvent = localStorage.getItem("preferredEvent");

  if (savedEvent) {
    console.log("Saved Event Found:", savedEvent);

    document.getElementById("eventType").value = savedEvent;
  }
};

/* Clear Preferences */

function clearPreferences() {
  console.log("Clearing Storage");

  localStorage.clear();

  sessionStorage.clear();

  alert("Preferences cleared successfully!");

  document.getElementById("eventType").value = "";
}

/* Geolocation */

function findLocation() {
  console.log("Finding User Location...");

  let output = document.getElementById("locationOutput");

  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      showPosition,
      showError,

      {
        enableHighAccuracy: true,
        timeout: 10000,
        maximumAge: 0,
      },
    );

    output.innerHTML = "Fetching your location...";
  } else {
    output.innerHTML = "Geolocation is not supported by this browser.";
  }
}

/* Location Success */

function showPosition(position) {
  let latitude = position.coords.latitude;

  let longitude = position.coords.longitude;

  console.log("Latitude:", latitude);
  console.log("Longitude:", longitude);

  document.getElementById("locationOutput").innerHTML =
    "Latitude: " +
    latitude +
    "<br>" +
    "Longitude: " +
    longitude +
    "<br><br>Nearby community events loaded successfully!";
}

/* Location Errors */

function showError(error) {
  let message = "";

  switch (error.code) {
    case error.PERMISSION_DENIED:
      console.log("Permission Denied");

      message = "Location access denied by user.";
      break;

    case error.POSITION_UNAVAILABLE:
      console.log("Position Unavailable");

      message = "Location information unavailable.";
      break;

    case error.TIMEOUT:
      console.log("Location Timeout");

      message = "Location request timed out.";
      break;

    case error.UNKNOWN_ERROR:
      console.log("Unknown Error");

      message = "An unknown error occurred.";
      break;
  }

  document.getElementById("locationOutput").innerHTML = message;
}

/* Before Unload Warning */

window.onbeforeunload = function () {
  if (formChanged) {
    return "You have unsaved changes. Are you sure you want to leave?";
  }
};
