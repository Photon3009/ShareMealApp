package com.example.sharemeal

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sharemeal.Data.UserSpecificD
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import java.net.Inet4Address

@Composable
fun DStatus(){

    val db = Firebase.firestore

    val userData4: MutableList<UserSpecificD> =  remember {
        mutableStateListOf()
    }
    var flag by remember {
        mutableStateOf(false)
    }


    if(flag==false){
        db.collection(FirebaseAuth.getInstance().getCurrentUser()?.getUid().toString())
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                    userData4.add(UserSpecificD(docId = document.id, docData = "${document.data}",
                        Address = "${document.data["Address"]}",MobNo="${document.data["MobNo"]}",
                        Vehicle = "${document.data["Vehicle"]}", weight = "${document.data["Weight"]}"))
                }

            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }}

    flag=true
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Card(elevation = 6.dp,
        border = BorderStroke(2.dp, Color.Red), modifier = Modifier
                .padding(3.dp)
                .padding(4.dp)
        ) {
            Text("Pending", modifier = Modifier.padding(4.dp))
        }
        Card(elevation = 6.dp,
            border = BorderStroke(2.dp, Color.Yellow),
            modifier = Modifier
                .padding(3.dp)
                .padding(4.dp)) {
            Text("Approved",modifier = Modifier.padding(4.dp))
        }
        Card(elevation = 6.dp,
            border = BorderStroke(2.dp, Color.Green),
            modifier = Modifier
                .padding(3.dp)
                .padding(4.dp)) {
            Text("Received",modifier = Modifier.padding(4.dp))
        }
    }
        Divider(thickness = 4.dp)

    for (e in userData4) {
   if(e.approve==false&&e.received==false){
       RedCard(weightF ="${e.weight}", vehicleT ="${e.Vehicle}", address ="${e.Address}", mobNo = "${e.MobNo}",
       docId = "${e.docId}")
   }
    if(e.approve==true&&e.received==false){
        YellowCard(weightF ="${e.weight}", vehicleT ="${e.Vehicle}", address ="${e.Address}", mobNo = "${e.MobNo}",
            docId = "${e.docId}")
    }
    if(e.approve==true&&e.received==true){
        GreenCard(weightF ="${e.weight}", vehicleT ="${e.Vehicle}", address ="${e.Address}", mobNo = "${e.MobNo}",
            docId = "${e.docId}")
    }
        
    }}}



@Composable
fun RedCard(weightF:String,vehicleT:String,address: String,mobNo:String,docId:String)
{
    Card(elevation = 6.dp,
        border = BorderStroke(2.dp, Color.Red), modifier = Modifier
            .padding(5.dp)
            .padding(8.dp)) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text("RefID: ${docId}", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))

            Text(text = "Food Weight: ${weightF}")
            Text(text = "Vehicle Type: ${vehicleT}")
            Text(text = "Address: ${address}")
            Text(text = "MobNo: ${mobNo}")
        }

    }
}

@Composable
fun YellowCard(weightF:String,vehicleT:String,address: String,mobNo:String,docId:String)
{
    Card(elevation = 6.dp,
        border = BorderStroke(2.dp, Color.Yellow), modifier = Modifier
            .padding(5.dp)
            .padding(8.dp)) {
        Column(modifier = Modifier.padding(5.dp)) {
        Text("RefID: ${docId}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(2.dp))

        Text(text = "Food Weight: ${weightF}")
        Text(text = "Vehicle Type: ${vehicleT}")
        Text(text = "Address: ${address}")
        Text(text = "MobNo: ${mobNo}")
    }
    }
}

@Composable
fun GreenCard(weightF:String,vehicleT:String,address: String,mobNo:String,docId:String)
{
    Card(elevation = 6.dp,
        border = BorderStroke(2.dp, Color.Green), modifier = Modifier
            .padding(5.dp)
            .padding(8.dp)) {
        Column(modifier = Modifier.padding(7.dp)) {
            Text("RefID: ${docId}", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Food Weight: ${weightF}")
            Text(text = "Vehicle Type: ${vehicleT}")
            Text(text = "Address: ${address}")
            Text(text = "MobNo: ${mobNo}")
        }
    }
}
@Preview
@Composable
fun Preview7(){
    DStatus()
}