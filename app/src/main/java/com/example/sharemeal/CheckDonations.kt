package com.example.sharemeal

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sharemeal.Data.UserSpecificD
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun CheckD(navController:NavController){
Column(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {


    val db = Firebase.firestore

    val userData5: MutableList<UserSpecificD> =  remember {
        mutableStateListOf()
    }
    var flag by remember {
        mutableStateOf(false)
    }


    if(flag==false){
        db.collection(  "ByqaeKNtlwZnV8ZWXYUfyJyWGpH3")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                    userData5.add(UserSpecificD(docId = document.id, docData = "${document.data}",
                        Address = "${document.data["Address"]}",MobNo="${document.data["MobNo"]}",
                        Vehicle = "${document.data["Vehicle"]}", weight = "${document.data["Weight"]}",approve = "${document.data["Approve"]}",
                        received = "${document.data["Received"]}"))
                }

            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }}

    flag=true
    for (e in userData5) {
    Card(elevation = 6.dp,
        border = BorderStroke(2.dp, color = Color.Gray), modifier = Modifier
            .padding(3.dp)
            .padding(4.dp)
            .fillMaxWidth()) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text("RefID: ${e.docId}", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Food Weight: ${e.weight}")
            Text(text = "Vehicle Type: ${e.Vehicle}")
            Text(text = "Address: ${e.Address}")
            Text(text = "MobNo: ${e.MobNo}")
            Row(horizontalArrangement = Arrangement.spacedBy(40.dp)
            ){
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    onClick = { db.collection("ByqaeKNtlwZnV8ZWXYUfyJyWGpH3").document("${e.docId}")
                        .update(mapOf("Approve" to "true"))
                              },
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
                    Text(text = "Approve", color = Color.White)
                }
                Button(
                onClick = {
                    db.collection("ByqaeKNtlwZnV8ZWXYUfyJyWGpH3").document("${e.docId}")
                        .update(mapOf("Received" to "true"))
                },
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
                    Text(text = "Received", color = Color.White)
                }
            }
        }
    }
    
}}

}

@Preview
@Composable
fun Preview10(){
    CheckD(navController = rememberNavController())
}