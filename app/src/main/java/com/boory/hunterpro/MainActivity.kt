package com.boory.hunterpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalLayoutDirection

private val Green = Color(0xFF00A86B)
private val Dark = Color(0xFF17221D)
private val Background = Color(0xFFF5F8F6)
private val Red = Color(0xFFE5484D)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Rtl
            ) {
                MaterialTheme(
                    colorScheme = lightColorScheme(
                        primary = Green,
                        background = Background,
                        surface = Color.White
                    )
                ) {
                    HunterHome()
                }
            }
        }
    }
}

@Composable
fun HunterHome() {
    Scaffold(
        containerColor = Background
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Column {
                    Text(
                        "BOORY HUNTER",
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Black,
                        color = Dark
                    )
                    Text(
                        "PRO  |  صياد زخم الأسهم الأمريكية",
                        color = Green,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Dark
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            "محرك الصيد الذكي",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "نراقب الأسهم الأمريكية الأقل من 10 دولارات",
                            color = Color.LightGray,
                            fontSize = 14.sp
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(9.dp)
                                    .background(
                                        Green,
                                        RoundedCornerShape(50)
                                    )
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                "واجهة التطبيق جاهزة",
                                color = Color(0xFF65E6A5),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            item {
                Text(
                    "لوحة الصياد",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Dark
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MetricCard(
                        "نطاق السعر",
                        "أقل من $10",
                        Green,
                        Modifier.weight(1f)
                    )
                    MetricCard(
                        "السوق",
                        "أمريكي",
                        Dark,
                        Modifier.weight(1f)
                    )
                }
            }

            item {
                Text(
                    "أنماط اكتشاف الفرص",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Dark
                )
            }

            item {
                FeatureCard(
                    "صيد ما قبل الاختراق",
                    "رصد التجميع والضغط السعري والاقتراب من المقاومة",
                    Green
                )
            }

            item {
                FeatureCard(
                    "الاختراق المؤكد",
                    "مراقبة تجاوز المقاومة مع تأكيد حجم التداول",
                    Green
                )
            }

            item {
                FeatureCard(
                    "تحليل السيولة والزخم",
                    "الحجم النسبي والتغير السعري وقوة الحركة",
                    Green
                )
            }

            item {
                FeatureCard(
                    "الأخبار والتقييم",
                    "تحليل الأخبار وتصنيف الفرص من 100",
                    Red
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            "حالة محرك السوق",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = Dark
                        )
                        Text(
                            "بانتظار ربط مصدر بيانات السوق الحية.",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                        Text(
                            "لن نعرض أسعاراً أو إشارات وهمية.",
                            color = Green,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            item {
                Text(
                    "BOORY HUNTER PRO © 2026",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun MetricCard(
    title: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(title, color = Color.Gray, fontSize = 13.sp)
            Spacer(Modifier.height(8.dp))
            Text(
                value,
                color = color,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun FeatureCard(
    title: String,
    description: String,
    accent: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .height(48.dp)
                    .background(
                        accent,
                        RoundedCornerShape(10.dp)
                    )
            )

            Spacer(Modifier.width(12.dp))

            Column {
                Text(
                    title,
                    color = Dark,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    description,
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }
    }
}
