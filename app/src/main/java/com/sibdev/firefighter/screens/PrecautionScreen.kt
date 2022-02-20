package com.sibdev.firefighter.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sibdev.firefighter.ui.theme.Shapes
import com.sibdev.firefighter.ui.theme.fonts

@Composable
fun PrecautionScreen(){

    LazyColumn(modifier = Modifier.fillMaxSize()){
        item{
            cards(
                text = "\n" +
                        "*    রান্নার পর চুলা সম্পূর্ণভাবে নিভিয়ে ফেলুন।\n" +
                        "*    ভেজা জামা কাপড় চুলার উপর শুকাতে দিবেন না।\n" +
                        "*    গ্যাসের চুলা জ্বালানোর পূর্বে কমপক্ষে ১৫ মিনিট পূর্বে রান্নাঘরের সকল জানালা/দরজা খুলে বাতাস চলাচলের ব্যবস্থা করুন।\n" +
                        "*    গ্যাসের চাবি অন করার পূর্বে ম্যাচের কাঠি ধরাবেন।\n" +
                        "*    গ্যাসের চুলার হোজপাইপটি ফাটা/ক্ষতিগ্রস্থ হলে পরিবর্তন করুন।\n"
            )
        }
        item {
            cards(text ="\n" +
                    "*    বাসাবাড়ির বৈদ্যুতিক লাইন প্রতি ০৬ মাস অন্তর অন্তর নিয়মিত পরীক্ষা করুন।\n" +
                    "*    সঠিক মানের বৈদ্যুতিক তার/সরঞ্জাম ব্যবহার করুন।\n" +
                    "*    অব্যবহৃত বৈদ্যুতিক সরঞ্জাম মূল লাইন থেকে বিচ্ছিন্ন রাখুন।\n" +
                    "*    ক্ষতিগ্রস্থ/নিম্নমানের বৈদ্যুতিক তার/সরঞ্জাম প্রতিস্থাপন করুন।\n" )
        }
        item { 
            cards(
                text = "\n" +
                        "*    বাসাবাড়ি/প্রতিষ্ঠান অগ্নি প্রতিরোধে প্রয়োজনীয় ব্যবস্থা নিন।\n" +
                        "*    অগ্নি ঝুঁকি অনুসারে প্রয়োজনীয় সংখ্য অগ্নি-নির্বাপক যন্ত্র মজুদ রাখুন।\n" +
                        "*    অগ্নি নির্বাপক যন্ত্রের প্রয়োগ ও ব্যবহার বিধি সম্পর্কে প্রশিক্ষণ নিন।\n"
            )
        }
        item {
            Spacer(modifier = Modifier.height(50.dp))
        }
    }



}

@Composable
fun cards(text:String){
    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier
        .padding(10.dp)) {
        Text(text = text,
            fontFamily = fonts,
            fontSize = 16.sp,
            modifier = Modifier.padding(10.dp))
    }
}