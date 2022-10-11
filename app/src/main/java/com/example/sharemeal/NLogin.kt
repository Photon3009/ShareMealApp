package com.example.sharemeal




import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sharemeal.ui.theme.ShareMealTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun NLoginScreen(navController: NavController,context: ComponentActivity) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }
    val context1= LocalContext.current
    val auth= Firebase.auth

    Box(contentAlignment = Alignment.BottomCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box (modifier = Modifier.wrapContentSize(align = Alignment.Center)){
                Image(
                    painter = painterResource(id = R.drawable.untitled_design7),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth()
                )
                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Spacer(modifier = Modifier.height(180.dp))
                    Text(
                        text = "NGO LOGIN",
                        fontSize = 35.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Log In with Email",
                        // color = LightTextColor,
                        //ontFamily = Poppins,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }

            }




            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                backgroundColor = Color.White,
                elevation = 0.dp,
                //  shape = BottomBoxShape.medium
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {


                    OutlinedTextField(
                        value = email, onValueChange = {
                            email = it
                        },
                        label = {
                            Text(text = "Email Address",)
                            //color = PrimaryColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            //unfocusedBorderColor = PrimaryColor,
                            //  textColor = PrimaryColor

                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType =
                            KeyboardType.Email
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_email_24),
                                contentDescription = "",
                                //tint = PrimaryColor,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    )

                    OutlinedTextField(
                        value = password, onValueChange = {
                            password = it
                        },
                        label = {
                            Text(text = "Password",)
                            //color = PrimaryColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            //   unfocusedBorderColor = PrimaryColor,
                            // textColor = PrimaryColor
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                                contentDescription = "",
                                // tint = PrimaryColor,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                                if (!isPasswordOpen) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "",
                                        // tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_eye_close_2),
                                        contentDescription = "",
                                        //  tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    )

                    Button(
                        onClick = {auth.signInWithEmailAndPassword(
                            email.trim(),
                            password.trim()
                        ).addOnCompleteListener(context){
                                task->
                            if(task.isSuccessful){
                                Log.d("AUTH","Success!")
                                Toast.makeText(context1,"Successfully LoggedIn", Toast.LENGTH_SHORT).show()

                                navController.navigate(Screen.NMenu.route)
                            }else{
                                Log.d("AUTH","Failed:${task.exception}")
                                Toast.makeText(context1,"Try Again", Toast.LENGTH_SHORT).show()
                            }}},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(123, 167, 149, 255)),
                        contentPadding = PaddingValues(vertical = 14.dp)
                    ) {

                        Text(text = "Login", )
                        //fontFamily = Poppins)
                    }



                    TextButton(
                        onClick = {navController.navigate(Screen.NRegisterScreen.route)},
                        contentPadding = PaddingValues(vertical = 0.dp)
                    ) {
                        Text(
                            text = "Don't have an Account ? Sign Up",
                            color=Color(123, 167, 149, 255),
                            fontSize = 12.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Preview3() {
    ShareMealTheme {
        NLoginScreen(navController = rememberNavController(),context=ComponentActivity())
    }
}