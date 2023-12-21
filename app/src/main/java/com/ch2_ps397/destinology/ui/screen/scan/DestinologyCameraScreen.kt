package com.ch2_ps397.destinology.ui.screen.scan

import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ch2_ps397.destinology.R
import com.ch2_ps397.destinology.core.di.Injection
import com.ch2_ps397.destinology.core.utils.Resource
import com.ch2_ps397.destinology.ui.ViewModelFactory
import com.ch2_ps397.destinology.ui.components.camera.CameraPreview
import com.ch2_ps397.destinology.ui.components.cards.DestinologyCardDialog
import com.ch2_ps397.destinology.ui.screen.user.CustomDialogPosition
import com.ch2_ps397.destinology.ui.screen.user.customDialogModifier
import com.ch2_ps397.destinology.ui.theme.Indigo
import com.ch2_ps397.destinology.ui.theme.IndigoLight
import com.ch2_ps397.destinology.ui.theme.White
import com.ch2_ps397.destinology.ui.theme.White20

@Composable
fun DestinologyCameraScreen(
    navController: NavController,
    cameraViewModel: DestinologyCameraViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideItineraryRepository(
                LocalContext.current
            ),
            Injection.provideLandmarkRepository(
                LocalContext.current
            ),
            Injection.provideUserRepository(
                LocalContext.current
            )
        )
    )
) {
    val context = LocalContext.current as Activity
    val cameraXPermissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.RECORD_AUDIO
    )

    val requiredPermissions = cameraXPermissions.all {
        ContextCompat.checkSelfPermission(
            context.applicationContext,
            it
        ) == PackageManager.PERMISSION_GRANTED
    }

    if (!requiredPermissions) {
        ActivityCompat.requestPermissions(
            context, cameraXPermissions, 0
        )
    }

    val controller = remember {
        LifecycleCameraController(context.applicationContext).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE
            )
        }
    }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val galleryLauncher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    imageUri?.let {
        val source = ImageDecoder
            .createSource(context.contentResolver,it)
        val bitmap = ImageDecoder.decodeBitmap(source)
        cameraViewModel.getImageFromGallery(bitmap)
    }
    var showDialog by remember { mutableStateOf(false) }

    cameraViewModel.bitmap.collectAsState().value.let { bitmap ->
        when (bitmap) {
            is Resource.Success -> {
                Scaffold(
                    bottomBar = {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Card(
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(16.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Indigo)
                                        .clickable {
                                            showDialog = true
                                            cameraViewModel.uploadImage(bitmap.data!!, context, navController)
                                        },
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Image(imageVector = Icons.TwoTone.Check, contentDescription = "Scan", colorFilter = ColorFilter.tint(
                                        White))
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    if (showDialog) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .customDialogModifier(CustomDialogPosition.TOP)
                        ){
                            DestinologyCardDialog(showDialog = showDialog) { showDialog = false }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        Image(bitmap = (bitmap.data)!!.asImageBitmap(), contentDescription = null)
                    }
                }
            }
            is Resource.Loading -> {
                showDialog = true
            }
            else -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CameraPreview(
                        controller = controller,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Card(
                            shape = CircleShape,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(IndigoLight)
                                    .clickable {
                                        galleryLauncher.launch("image/*")
                                    },
                                contentAlignment = Alignment.Center,
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_image_24),
                                    contentDescription = "capture",
                                    colorFilter = ColorFilter.tint(Indigo)
                                )
                            }
                        }
                        Card(
                            shape = CircleShape,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Indigo)
                                    .clickable {
                                        takePhoto(
                                            applicationContext = context.applicationContext,
                                            controller = controller,
                                        ) { bitmap ->
                                            cameraViewModel.onTakePhoto(bitmap)
                                        }
                                    },
                                contentAlignment = Alignment.Center,
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_capture_24),
                                    contentDescription = "capture",
                                    colorFilter = ColorFilter.tint(White)
                                )
                            }
                        }
                        Card(
                            shape = CircleShape,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(IndigoLight)
                                    .clickable {
                                        controller.cameraSelector =
                                            if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                                                CameraSelector.DEFAULT_FRONT_CAMERA
                                            } else CameraSelector.DEFAULT_BACK_CAMERA
                                    },
                                contentAlignment = Alignment.Center,

                                ) {
                                Image(
                                    painter = painterResource(
                                        id = R.drawable.baseline_cameraswitch_24
                                    ),
                                    contentDescription = "Switch camera",
                                    colorFilter = ColorFilter.tint(Indigo)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
