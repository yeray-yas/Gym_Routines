package com.yerayyas.gymroutines.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    onWorkoutClick: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()

) {
    val state = viewModel.state

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {

        item {
            Column {
                val appendable = buildAnnotatedString {
                    append("Hello,")
                    withStyle(style = SpanStyle(color = Color.Green)) {
                        append(" Yeray")
                    }
                }
                Text(text = appendable)
                Text(
                    text = "Let's start your day",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        item { Spacer(modifier = Modifier.height(40.dp)) }
        item { Text(text = "Workouts", fontWeight = FontWeight.SemiBold, fontSize = 16.sp) }
        item { Spacer(modifier = Modifier.height(24.dp)) }

        items(state.routines) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        onWorkoutClick(it.id)
                    }
            ) {
                Image(
                    painter = painterResource(id = com.yerayyas.gymroutines.R.drawable.workout_background),
                    contentDescription = null, contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = it.name,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}