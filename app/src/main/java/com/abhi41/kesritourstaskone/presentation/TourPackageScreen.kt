package com.abhi41.kesritourstaskone.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BedroomParent
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.LocalAirport
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.abhi41.kesritourstaskone.R
import com.abhi41.kesritourstaskone.domain.model.TOURMAS0
import com.abhi41.kesritourstaskone.domain.model.TourItem
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TourPackageScreen() {
    val viewModel: TourInfoViewModel = hiltViewModel()
    val state = viewModel.state.value
    val scaffoldState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is TourInfoViewModel.UIEvent.ShowSnackBar -> {
                    scaffoldState.showSnackbar(event.message)
                }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            if (state.tourInfoItem.isNotEmpty()) state.tourInfoItem[0].tourName else "",
            modifier = Modifier.height(50.dp)
        )
        TourPackagesList(state.tourInfoItem ?: emptyList())
    }
}

@Composable
fun TopAppBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Red),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .weight(2f)
        )

        Text(
            modifier = Modifier.weight(5f),
            text = name,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
    }
}

@Composable
fun TourPackagesList(
    touristInfoList: List<TourItem>
) {
    LazyColumn {
        items(touristInfoList) { item: TourItem ->
            SingleTouristItem(item)
        }
    }

}

@Composable
fun SingleTouristItem(item: TourItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .height(200.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Start) {
            ImageSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f),
                item = item
            )

            DescriptionSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(6f),
                item = item
            )

        }

    }
}

@Composable
private fun ImageSection(
    modifier: Modifier = Modifier,
    item: TourItem
) {
    val painter = rememberImagePainter(
        data = item.images[0],
        builder = {
            placeholder(R.drawable.webp)
            error(R.drawable.baseline_broken_image_24)
        }
    )
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopImageSection(item)
            ImageBottomIcons()
        }

    }
}

@Composable
private fun TopImageSection(item: TourItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CircularShapeBox()
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(end = 6.dp)) {

            Text(
                text = "TOURCODE",
                color = Color.White,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = item.tourCode,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Composable
private fun ImageBottomIcons() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color(0x9C000000),
                        Color(0xCD000000),
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                imageVector = Icons.Default.BedroomParent,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Icon(
                imageVector = Icons.Default.Restaurant,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Icon(
                imageVector = Icons.Default.DirectionsBus,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Icon(
                imageVector = Icons.Default.LocalAirport,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun DescriptionSection(
    modifier: Modifier = Modifier,
    item: TourItem
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(6.dp),
            text = item.tourName,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.numberOfNights.toString(),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Nights", color = Color.DarkGray,fontSize = 12.sp)
                Spacer(modifier = Modifier.height(6.dp))
                HorizontalLine()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = item.total_country.toString(),
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Country", color = Color.DarkGray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(6.dp))
                    HorizontalLine(modifier = Modifier.padding(3.dp))
                    Text(
                        text = item.total_city.toString(),
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Cities", color = Color.DarkGray,fontSize = 12.sp)
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            VerticalLine()
            Column(modifier = Modifier.weight(8f)) {

                Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            fontSize = 12.sp
                        )){
                             append("Joining   <  ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = colorResource(id = R.color.dark_green),
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        ) {
                            append(item.start_city)
                        }
                    })
                }

                Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            fontSize = 12.sp
                        )){
                            append("Leaving   >  ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        ) {
                            append(item.end_city)
                        }
                    })
                }
                HorizontalLine(modifier = Modifier.padding(top = 3.dp))
                Column(
                    modifier = Modifier.fillMaxWidth().weight(6f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "All inclusive price | Per Person",
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.generated_NETCOST.toString(),
                        fontSize = 15.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.generated_NETCOST.toString(),
                        fontSize = 20.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.height(30.dp),
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Text(text = "YOU SAVE 7,000", fontSize = 12.sp)
                    }
                }
            }

        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.numberOfNights.toString(),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Nights", color = Color.DarkGray)
                Spacer(modifier = Modifier.height(6.dp))
                HorizontalLine()
            }
        }


    }
}

@Composable
private fun VerticalLine() {
    Row(horizontalArrangement = Arrangement.Center) {
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp), color = Color.Gray
        )
    }
}

@Composable
private fun HorizontalLine(
    modifier: Modifier = Modifier
) {
    Row(horizontalArrangement = Arrangement.Center, modifier = modifier) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Color.Gray
        )
    }
}

@Composable
fun CircularShapeBox() {
    // You can place your content inside the circular box here
    Box(
        modifier = Modifier
            .clip(shape = CircleShape)
            .padding(1.dp),
    ) {
        Box(
            // color = Color.Red,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bonanza",
                    color = Color.White, fontSize = 10.sp
                )
                Text(
                    text = "Offer",
                    color = Color.White, fontSize = 10.sp
                )
                Text(
                    text = "\u20B9",
                    color = Color.White, fontSize = 10.sp
                )
            }
        }
    }

}

/*@Preview
@Composable
fun TourPackageScreenPreview() {
    TourPackageScreen()
}*/

@Preview(device = Devices.PIXEL)
@Preview(device = Devices.NEXUS_7)
@Composable
fun SingleTouristItemPreview() {
    SingleTouristItem(
        TourItem(
            tourCode = "SY",
            tourName = "ANDAMAN WITH HAVELOCK ECONOMY",
            tm_Zone = "Andaman",
            images = listOf("https://d3r8gwkgo0io6y.cloudfront.net/upload/SZ/SZ.jpg"),
            bestSeller = "null",
            start_country = "India",
            generated_DISC_2DAY = 38990,
            generated_NETCOST = 31990,
            start_city = "Port Blair",
            end_city = "Havelock",
            total_city = 2,
            journeyCategory = "REGULAR",
            tourmas0Item = TOURMAS0(7),
            total_country = 1,
            numberOfNights = 4,
        )
    )
}