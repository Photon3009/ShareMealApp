package com.example.sharemeal

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.ui.tooling.preview.Preview
import com.example.sharemeal.ui.theme.Shapes
import com.example.sharemeal.ui.theme.ShareMealTheme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase




@Composable
fun DRegisterScreen(navController:NavController,context: ComponentActivity) {
    val auth=Firebase.auth
    val context2= LocalContext.current

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNo by remember { mutableStateOf("") }
    var checkBoxOne by remember { mutableStateOf(true) }
    var checkBoxTwo by remember { mutableStateOf(true) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.untitled_design_),
                contentDescription = "",
                modifier = Modifier.size(160.dp)
            )

            Text(
                text = "DONOR REGISTRATION",
                textAlign = TextAlign.Center,
                // fontFamily = Poppins,
                //color = SecondaryColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,

                )

            TextField(
                value = username, onValueChange = { username = it },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    // textColor = PrimaryColor,
                    backgroundColor = Color(217, 217, 217),
                    //cursorColor = PrimaryColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                // shape = InputBoxShape.medium,
                singleLine = true,
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_face_24),
                            contentDescription = "",
                            // tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .height(24.dp)
                            //  .background(BackgroundColor)
                        )
                    }
                },
                placeholder = {
                    Text(text = "Username")
                    //color = PlaceholderColor)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    // fontFamily = Poppins
                )
            )

            TextField(
                value = email, onValueChange = { email = it },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    // textColor = PrimaryColor,
                    backgroundColor = Color(217, 217, 217),
                    // cursorColor = PrimaryColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                // shape = InputBoxShape.medium,
                singleLine = true,
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_email_24),
                            contentDescription = "",
                            //  tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .height(24.dp)
                            //  .background(BackgroundColor)
                        )
                    }
                },
                placeholder = {
                    Text(text = "Email Address")
                    //color = PlaceholderColor)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    //  fontFamily = Poppins
                )
            )

            TextField(
                value = phoneNo, onValueChange = { phoneNo = it },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    // textColor = PrimaryColor,
                    backgroundColor = Color(217, 217, 217),
                    //cursorColor = PrimaryColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                //shape = InputBoxShape.medium,
                singleLine = true,
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_local_phone_24),
                            contentDescription = "",
                            // tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .height(24.dp)
                            // .background(BackgroundColor)
                        )
                    }
                },
                placeholder = {
                    Text(text = "Phone Number")
                    //color = PlaceholderColor)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    // fontFamily = Poppins
                )
            )


            TextField(
                value = password, onValueChange = { password = it },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    // textColor = PrimaryColor,
                    backgroundColor = Color(217, 217, 217),
                    //cursorColor = PrimaryColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                //shape = InputBoxShape.medium,
                singleLine = true,
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                            contentDescription = "",
                            // tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .height(24.dp)
                            // .background(BackgroundColor)
                        )
                    }
                },
                placeholder = {
                    Text(text = "Password")
                    //color = PlaceholderColor)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    // fontFamily = Poppins
                )
            )






            Button(
                onClick = {
                          auth.createUserWithEmailAndPassword(
                              email.trim(),
                              password.trim()
                          ).addOnCompleteListener(context){
                              task->
                              if(task.isSuccessful){
                                  Log.d("AUTH","Success!")
                                  Toast.makeText(context2,"Successfully Registered", Toast.LENGTH_SHORT).show()
                              }else{
                                  Log.d("AUTH","Failed:${task.exception}")
                                  Toast.makeText(context2,"Try Again",Toast.LENGTH_SHORT).show()
                              }
                          }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(123, 167, 149, 255)),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                contentPadding = PaddingValues(vertical = 14.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 2.dp
                ),
                // shape = Shapes.medium
            ) {
                Text(
                    text = "Submit",
                    // fontFamily = Poppins,
                    //color = SecondaryColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            TextButton(
                onClick = { navController.navigate(Screen.Dlogin.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),

                ) {
                Text(
                    text = "Already have an account ? Sign In",
                    //fontFamily = Poppins,
                    // color= SecondaryColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(123, 167, 149, 255)
                )
            }


        }
    }



@Preview(showBackground = true)
@Composable
fun Preview() {
    ShareMealTheme {
        DRegisterScreen(navController = rememberNavController(), context = ComponentActivity())
    }
}