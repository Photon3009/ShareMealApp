package com.example.sharemeal

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.location.Address
import android.util.Log
import android.util.MutableBoolean
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sharemeal.Data.UserSpecificD
import java.util.*
import kotlin.collections.HashMap

@SuppressLint("UnrememberedMutableState")
@Composable
fun DHistoryScreen(navController: NavController) {
    val db = Firebase.firestore


    val userData3: MutableList<UserSpecificD> =  remember {
        mutableStateListOf()}
    var flag by remember {
        mutableStateOf(false)
    }


if(flag==false){
    db.collection(FirebaseAuth.getInstance().getCurrentUser()?.getUid().toString())
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.d(TAG, "${document.id} => ${document.data}")
                userData3.add(UserSpecificD(docId = document.id, docData = "${document.data}",
                    Address = "${document.data["Address"]}",MobNo="${document.data["MobNo"]}",
                Vehicle = "${document.data["Vehicle"]}", weight = "${document.data["Weight"]}",approve = "${document.data["Approve"]}",
                    received = "${document.data["Received"]}"))
            }

        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }}

    flag=true

    Column(modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center) {
        Spacer(modifier=Modifier.height(4.dp))


            Column(modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())) {

                    for (e in userData3) {
                        Card(elevation = 4.dp) {
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)) {
                                Text("RefID: ${e.docId}", fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(text = "Food Weight: ${e.weight}")
                                Text(text = "Vehicle Type: ${e.Vehicle}")
                                Text(text = "Address: ${e.Address}")
                                Text(text = "MobNo: ${e.MobNo}")
                            }
                        }
                        Spacer(modifier=Modifier.height(5.dp))
                    }

            }

    }
}



@Preview
@Composable
fun Preview6(){
    DHistoryScreen(navController = rememberNavController())
}