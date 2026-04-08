<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <!-- <link rel="stylesheet" href="Style_Reg.css"> -->
</head>

<body>
    <div id="registration">
        <h2>Sign Up</h2>
        <form id="registerForm" novalidate>
            <div class="input_boxes">
                <label for="username">UserName</label>
                <input type="text" id="username" name="username" required>
                <span class="error-message" id="usernameError"></span>

                <label for="acc">Account Number</label>
                <input type="text" id="acc" name="acc" required>
                <span class="error-message" id="accError"></span>

                <label for="phone">Phone Number</label>
                <input type="tel" id="phone" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                    placeholder="123-456-7890" required>
                <span class="error-message" id="phoneError"></span>

                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
                <span class="error-message" id="passwordError"></span>

                <label for="cpassword">Confirm Password</label>
                <input type="password" id="cpassword" name="cpassword" required>
                <span class="error-message" id="cpasswordError"></span>
            </div>
        </form>
        <button type="button" id="registerBtn" class="button">Register</button>
        <div class="login_link">
            <a href="login.jsp">Already have account? Login</a>
        </div>
    </div>

    <!----------------------------------------- Custom Style------------------------------------>

    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url(bg.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            color: aliceblue;
            /* overflow: hidden; */
        }

        #registration {
            margin: 2% 30%;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
            padding: 20px;
        }

        .input_boxes {
            display: flex;
            flex-direction: column;
            justify-content: center;

        }

        .input_boxes input {
            border: none;
            padding: 5px;
            margin: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
            background-color: aliceblue;
            border-radius: 20px;
            align-items: center;
        }

        .input_boxes label {
            font-weight: bold;
            padding: 3px;
        }

        .error-message {
            color: #ffbbbb;
            font-size: 0.85rem;
            margin: 2px 20px 10px;
            min-height: 18px;
            display: block;
        }

        input.invalid {
            border: 1px solid #ff9a9a;
            box-shadow: 0 0 10px rgba(255, 154, 154, 0.25);
        }

        .button {
            border: none;
            box-shadow: 0 0 15px rgba(143, 236, 205, 0.5);
            border-radius: 30px;
            background-color: rgb(15, 136, 110);
            text-align: center;
            margin: 20px;
            padding: 10px 20px;
            cursor: pointer;
            transition: transform 0.3s ease;
        }

        .button:hover {
            transform: scale(1.1);
        }

        .login_link a {
            text-decoration: none;
            color: rgb(253, 250, 250);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-weight: bold;
            padding: 10px;
        }
    </style>

    <!-----------------------------------------JavaScript --------------------------------------->
    
    <script>
        const form = document.getElementById('registerForm');
        const fields = [
            { id: 'username', name: 'Username' },
            { id: 'acc', name: 'Account Number' },
            { id: 'phone', name: 'Phone Number' },
            { id: 'password', name: 'Password' },
            { id: 'cpassword', name: 'Confirm Password' }
        ];

        function clearErrors() {
            fields.forEach(field => {
                const error = document.getElementById(field.id + 'Error');
                error.textContent = '';
                document.getElementById(field.id).classList.remove('invalid');
            });
        }

        function showError(id, message) {
            const error = document.getElementById(id + 'Error');
            const input = document.getElementById(id);
            error.textContent = message;
            input.classList.add('invalid');
        }

        function validateForm() {
            clearErrors();
            let isValid = true;

            fields.forEach(field => {
                const input = document.getElementById(field.id);
                if (!input.value.trim()) {
                    showError(field.id, `${field.name} is required.`);
                    isValid = false;
                }
            });

            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('cpassword').value;
            if (password && confirmPassword && password !== confirmPassword) {
                showError('cpassword', 'Passwords do not match.');
                isValid = false;
            }

            const phoneInput = document.getElementById('phone');
            if (phoneInput.value && !phoneInput.checkValidity()) {
                showError('phone', 'Enter a phone number in 123-456-7890 format.');
                isValid = false;
            }

            const emailInput = document.getElementById('acc');
            if (emailInput.value && !emailInput.checkValidity()) {
                showError('acc', 'Please enter a valid account number.');
                isValid = false;
            }

            return isValid;
        }

        document.getElementById('registerBtn').addEventListener('click', function () {
            if (validateForm()) {
                alert('Registration Successful');
                window.location.href = 'Dashboard.html';
            }
        });
    </script>
</body>

</html>
