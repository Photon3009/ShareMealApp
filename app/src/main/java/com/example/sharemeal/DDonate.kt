package com.example.sharemeal

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun DDonate(navController: NavController){




    val weightList by remember {mutableStateOf(listOf("1-10kg","10-30kg","30-50kg","50-100kg"))}
    var weightF by remember { mutableStateOf("")}
    val vehicleList by remember {mutableStateOf(listOf("Bike","Car","Van","Truck"))}
    var vehicleF by remember { mutableStateOf("")}
    var address by remember {
        mutableStateOf("")}
    var mobno by remember { mutableStateOf("")}

    val scrollState= rememberScrollState()

    val db = Firebase.firestore
    Column(modifier = Modifier.verticalScroll(state=scrollState),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween){
        Card(elevation=5.dp, modifier = Modifier.padding(15.dp)){
            Column(modifier=Modifier.padding(14.dp)) {
               Row(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(),
                   horizontalArrangement = Arrangement.spacedBy(120.dp),

                   ) {
                   Text("Donation Weight Type:", fontSize = 18.sp)

                   Icon(
                       painter = painterResource(id = R.drawable.ic_kg_measure_weight_icon),
                       contentDescription = "",
                       modifier = Modifier.size(60.dp)
                   )
               }
                Spacer(modifier = Modifier.height(18.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),

                    ){
                    weightList.forEach{
                        Row(modifier = Modifier.padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly){

                            RadioButton(selected = weightF==it, onClick = { weightF=it },
                            colors = RadioButtonDefaults.colors(Color(123, 167, 149, 255)))
                            Text(it,fontSize=15.sp)
                        }
                    }

                }


            }
        }
        Card(elevation=5.dp, modifier = Modifier.padding(15.dp)){
            Column(modifier=Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(),
                    horizontalArrangement = Arrangement.spacedBy(120.dp),

                    ) {
                    Text("Suggest Vehicle Type:", fontSize = 18.sp)

                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
                        contentDescription = "",
                        modifier = Modifier.size(60.dp)
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),

                    ){
                    vehicleList.forEach{
                        Row(modifier = Modifier.padding(4.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly){

                            RadioButton(selected = vehicleF==it, onClick = {vehicleF=it },
                                colors = RadioButtonDefaults.colors(Color(123, 167, 149, 255)))
                            Text(it,fontSize=15.sp)
                        }
                    }

                }


            }
        }

        OutlinedTextField(
            value = address, onValueChange = {
                address = it
            },
            label = {
                Text(text = "Address")

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(123, 167, 149, 255),
            ))

        OutlinedTextField(
            value = mobno, onValueChange = {
                mobno = it
            },
            label = {
                Text(text = "Mobile Number")

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(123, 167, 149, 255), focusedBorderColor = Color(123, 167, 149, 255)))
Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { navController.navigate(Screen.DMenu.route)
// Create a new user with a first and last name
                val user = hashMapOf(
                    "Weight" to weightF,
                    "Vehicle" to vehicleF,
                "Address" to address,
                "MobNo" to mobno,
                    "Approve" to "false",
                    "Received" to "false"
                )


// Add a new document with a generated ID
                db.collection(FirebaseAuth.getInstance().getCurrentUser()?.getUid().toString())
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }

                    },


            modifier=Modifier.fillMaxWidth(),
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
            Text(text = "Submit", color = Color.White)
        }

    }



}
@Preview(showBackground =true)
@Composable
fun Preview5(){
    DDonate(navController = rememberNavController())
}