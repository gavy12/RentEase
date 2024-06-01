package com.example.rentease

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rentease.ui.theme.RentEaseTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RentEaseTheme {
                HomeScreen()
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SearchBar()
            CarBrandsSection()
            CarListSection()
        }
    }
}

@Composable
fun SearchBar() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text("Search Bar", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun CarBrandsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        CarBrandItem("Mercedes", R.drawable.icon_car_brand_mercedes)
        CarBrandItem("BMW", R.drawable.icon_car_brand_bmw)
        CarBrandItem("Porsche", R.drawable.icon_car_brand_porsche)
        CarBrandItem("Renault", R.drawable.icon_car_brand_renault)
    }
}

@Composable
fun CarBrandItem(brandName: String, brandLogoRes: Int) {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .size(100.dp)
    ) {
        Image(
            painter = painterResource(id = brandLogoRes),
            contentDescription = brandName,
            modifier = Modifier.size(60.dp).align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Text(
            text = brandName,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun CarListSection() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        CarItem("S 500 Sedan", "Automatic", "5 seats", "Diesel", true, R.drawable.s500sedan_image)
        CarItem("GLA 250 SUV", "Automatic", "7 seats", "Diesel", false, R.drawable.gla250suv_image)
    }
}

@Composable
fun CarItem(
    carName: String,
    transmission: String,
    seats: String,
    fuel: String,
    isSelected: Boolean,
    carImageRes: Int
) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = carImageRes),
                contentDescription = carName,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = carName, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(vertical = 8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text(text = transmission)
                Text(text = seats)
                Text(text = fuel)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                if (isSelected) {
                    Button(onClick = { }) { Text("Selected") }
                } else {
                    Button(onClick = { }) { Text("Select") }
                }
                Button(onClick = { }) { Text("Detail") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RentEaseTheme {
        HomeScreen()
    }
}
