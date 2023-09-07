package com.mynpe.deleteitemoflazycolumndemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mynpe.deleteitemoflazycolumndemo.ui.theme.DeleteItemofLazyColumnDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeleteItemofLazyColumnDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BasicItemsList(itemList = getListItems())
                }
            }
        }
    }
}

@Composable
fun  BasicItemsList(itemList: List<BasicItems>) {
    
    val deletedItem = remember { mutableStateListOf<BasicItems>() }
    
    Column(
        modifier = Modifier.fillMaxSize()        
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(MaterialTheme.colors.primary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "List of Basic Items",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column() {
           LazyColumn(modifier = Modifier.fillMaxWidth()) {
               itemsIndexed(
                   items = itemList,
                   itemContent =  { _, item ->
                       AnimatedVisibility(
                           visible = !deletedItem.contains(item),
                            enter = expandVertically(),
                           exit = shrinkVertically(animationSpec = tween(durationMillis = 1000))
                       ) {
                           Card(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .height(100.dp)
                                   .padding(10.dp, 5.dp, 10.dp, 5.dp)
                                   .background(Color.White),
                               elevation = 20.dp,
                               shape = RoundedCornerShape(5.dp)
                           ) {
                               Column(modifier = Modifier.padding(10.dp)) {
                                   Row(
                                       modifier = Modifier.fillMaxWidth(),
                                       horizontalArrangement = Arrangement.SpaceBetween,
                                       verticalAlignment = Alignment.CenterVertically
                                   ) {
                                        Text(
                                            text = item.name,
                                            style = TextStyle(
                                                color = Color.Black,
                                                fontSize = 20.sp,
                                                textAlign = TextAlign.Center,
                                            ),
                                            modifier = Modifier.padding(20.dp)
                                        )
                                       IconButton(onClick = {
                                           deletedItem.add(item)
                                       }) {
                                            Icon(
                                                imageVector = Icons.Filled.Delete,
                                                contentDescription = "Deletion"
                                            )
                                       }
                                   }
                               }
                           }
                       }
               }
               )
           }
        }
    }
    
}




