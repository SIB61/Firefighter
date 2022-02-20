package com.sibdev.firefighter.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sibdev.firefighter.utils.Screens

@Composable
fun UrgentStepScreen(){
    LazyColumn(Modifier.fillMaxSize()){
        item {
            cards(
                text = "\n" +
                        "*    বিলম্ব না করে নিকটস্থ ফায়ার স্টেশনে সংবাদ দিন/অথবা কেন্দ্রীয় নিয়ন্ত্রণ কক্ষে (০২-২২৩৩৫৫৫৫৫/০১৭৩০৩৩৬৬৯৯)অবহিত করুন\n" +
                        "*    শুরুতেই আগুন নিভানোর চেষ্টা করুন\n" +
                        "*    বহনযোগ্য অগ্নিনির্বাপনী যন্ত্র ব্যবহার করুন\n" +
                        "*    বৈদ্যুতিক লাইনে/যন্ত্রপাতিতে আগুন ধরলে পানি ব্যবহার করবেননা। বহনযোগ্য কার্বন ডাই-অক্সাইড/ড্রাইকেমিক্যাল পাউডার এক্সটিংগুইসার ব্যবহার করুন। না পেলে শুকনো বালি ব্যবহার করুন। \n" +
                        "*    তৈল জাতীয় পদার্থের আগুনে পানি ব্যবহার বিপদজনক। বহনযোগ্য ফোমটাইপ ফায়ার এক্সটিংগুইসার/শুকনো বালি/ ভেজা মোটা কাপড় বা চটের বস্তা দ্বারা চাপা দিন।\n" +
                        "*    গায়ে বা পড়নের কাপড়ে আগুন ধরলে মাটিতে গড়াগড়ি করুন।\n"
            )
        }
    }
}