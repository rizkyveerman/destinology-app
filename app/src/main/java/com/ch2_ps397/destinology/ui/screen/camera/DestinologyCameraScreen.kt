package com.ch2_ps397.destinology.ui.screen.camera

import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Bitmap
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyCameraScreen(
    navController: NavController,
    cameraXScreenViewModel: DestinologyCameraViewModel = viewModel(
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

    cameraXScreenViewModel.bitmap.collectAsState().value.let { bitmap ->
        when (bitmap) {
            is Resource.Success -> {
                Scaffold(
                    bottomBar = {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .padding(16.dp)
                                    .background(
                                        Color.White
                                    )
                                    .clickable {
                                        takePhoto(
                                            applicationContext = context.applicationContext,
                                            controller = controller,
                                        ) { bitmap ->
                                            val imageFile = File(context.cacheDir, "landmark")
                                            imageFile.createNewFile()

                                            val byteArrayOutputStream = ByteArrayOutputStream()
                                            bitmap.compress(
                                                Bitmap.CompressFormat.JPEG,
                                                100,
                                                byteArrayOutputStream
                                            )
                                            val byteArray = byteArrayOutputStream.toByteArray()

                                            val fileOutputStream = FileOutputStream(imageFile)
                                            fileOutputStream.write(byteArray)
                                            fileOutputStream.flush()
                                            fileOutputStream.close()

                                            val requestImageFile =
                                                imageFile.asRequestBody("image/jpeg".toMediaType())
                                            val multipartBody = MultipartBody.Part.createFormData(
                                                "landmark-photo",
                                                imageFile.name,
                                                requestImageFile
                                            )
                                            cameraXScreenViewModel.uploadImage(multipartBody)
                                        }
                                    },
                                contentAlignment = Alignment.Center,
                            ) {
                                Image(imageVector = Icons.TwoTone.Check, contentDescription = "Scan")
                            }
                        }
                    }
                ) { innerPadding ->
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
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .padding(16.dp)
                                .background(
                                    Color.White
                                )
                                .clickable {
                                    takePhoto(
                                        applicationContext = context.applicationContext,
                                        controller = controller,
                                    ) { bitmap ->
                                        cameraXScreenViewModel.onTakePhoto(bitmap)
                                    }
                                },
                            contentAlignment = Alignment.Center,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_capture_24),
                                contentDescription = "capture"
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .padding(16.dp)
                                .background(
                                    Color.White
                                )
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
                                contentDescription = "Switch camera"
                            )
                        }
                    }
                }
            }
        }
    }
}
