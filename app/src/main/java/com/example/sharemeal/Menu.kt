package com.example.sharemeal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

@Composable
fun DMenu(navController: NavController){

    Surface(color = Color.White) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
           // Spacer(modifier = Modifier.height(16.dp))


            Image(
                painter = painterResource(R.drawable.untitled_design_),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Text("Welcome Donor", fontSize = 30.sp)

            Card(backgroundColor = Color.White, elevation = 10.dp ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {

                    Button(
                        onClick = { navController.navigate(Screen.DDonate.route) },
                        Modifier.fillMaxWidth(),
                        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(
                                123,
                                167,
                                149,
                                255
                            )
                        ),
                    )
                    {
                        Text(text = "Donate", color = Color.White)
                    }
                    Button(
                        onClick = { navController.navigate(Screen.DStatus.route) },
                        Modifier.fillMaxWidth(),
                        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(
                                123,
                                167,
                                149,
                                255
                            )
                        ),
                    )
                    {
                        Text(text = "Status", color = Color.White)
                    }
                    Button(
                        onClick = { navController.navigate(Screen.DHistoryScreen.route) },
                        Modifier.fillMaxWidth(),
                        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(
                                123,
                                167,
                                149,
                                255
                            )
                        ),
                    )
                    {
                        Text(text = "History", color = Color.White)
                    }
                    Button(
                        onClick = { navController.navigate(Screen.Home.route)
                                  FirebaseAuth.getInstance().signOut()},
                        Modifier.fillMaxWidth(),
                        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(
                                123,
                                167,
                                149,
                                255
                            )
                        ),
                    )
                    {
                        Text(text = "LogOut", color = Color.White)
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview4(){
    DMenu(navController = rememberNavController())
}