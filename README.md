# AuraView - Android TV Ad-Blocking VPN

**Clear Vision, Ad-Free Streaming**

AuraView is a comprehensive ad-blocking VPN solution specifically designed for Android TV devices. It provides seamless ad and tracker blocking while maintaining optimal streaming performance.

## Features

- **Advanced Ad Blocking**: Blocks ads and trackers using uBlockOrigin filter lists
- **Android TV Optimized**: Designed for 10-foot interface with remote control navigation
- **Real-time Statistics**: Track blocked queries and data savings
- **Auto-start**: Automatically enable protection on device boot
- **Filter Management**: Enable/disable specific filter categories
- **Background Updates**: Automatic filter list updates
- **Performance Optimized**: Minimal impact on streaming performance

## Requirements

- **Android TV Device** (Android 5.0+ / API 21+)
- **VPN Permission**: Required for traffic interception
- **Internet Connection**: For filter updates and DNS resolution

## Installation

### Method 1: From APK (Recommended for Testing)

1. **Download the APK**
   ```bash
   # Build from source or download pre-built APK
   ./gradlew assembleDebug
   ```

2. **Transfer to Android TV**
   - Copy `app/build/outputs/apk/debug/app-debug.apk` to your Android TV device
   - Use ADB: `adb connect <TV_IP> && adb install app-debug.apk`
   - Or use a file manager app on your TV

3. **Install and Launch**
   - Open the APK file on your Android TV
   - Follow the installation prompts
   - Launch AuraView from your apps

### Method 2: Build from Source

1. **Prerequisites**
   ```bash
   # Install Android Studio or Android SDK
   # Install JDK 11+
   # Install Android SDK with API 34
   ```

2. **Clone and Setup**
   ```bash
   git clone <repository-url>
   cd AuraView
   ```

3. **Build the Project**
   ```bash
   # Using Gradle wrapper
   ./gradlew build

   # Or using installed Gradle
   gradle build
   ```

4. **Install on Device**
   ```bash
   # Connect to Android TV
   adb connect <TV_IP_ADDRESS>:5555

   # Install APK
   ./gradlew installDebug

   # Or manually
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

## Initial Setup

1. **Launch AuraView**
   - Open the app from your Android TV home screen

2. **Grant VPN Permission**
   - The app will request VPN permission on first launch
   - Tap "OK" to grant the permission
   - This is required for ad blocking functionality

3. **Initial Filter Download**
   - The app will automatically download filter lists
   - This may take a few minutes on first launch

4. **Enable Protection**
   - Use the large "Enable Protection" button on the home screen
   - The VPN service will start and begin blocking ads

## Usage

### Basic Operation

- **Enable/Disable Protection**: Use the main toggle button on the home screen
- **View Statistics**: Navigate to the Statistics section to see blocked queries and data savings
- **Manage Filters**: Access filter management to enable/disable specific filter categories

### Navigation

AuraView is designed for Android TV remote control navigation:

- **DPad**: Navigate between UI elements
- **Select/Enter**: Activate buttons and options
- **Back**: Return to previous screen
- **Home**: Return to main screen

### Settings

Access settings to configure:

- **Auto-start**: Enable protection on device boot
- **DNS Server**: Choose between Cloudflare, Google, or Quad9
- **Update Frequency**: Set how often filters are updated
- **Advanced Options**: Block UDP 53 and other advanced settings

## Filter Lists

AuraView uses the following filter lists from uBlockOrigin:

- **uBlock Filters**: Main ad blocking rules
- **Privacy Protection**: Tracker and analytics blocking
- **Malware Domains**: Known malicious domains
- **Annoyances**: Annoying elements and overlays
- **Mobile Ads**: Mobile-specific ad blocking
- **Badware**: Malicious software domains

## Troubleshooting

### VPN Won't Start

1. **Check VPN Permission**: Ensure VPN permission was granted during setup
2. **Restart App**: Close and reopen the app
3. **Restart Device**: Reboot your Android TV device

### Filters Not Updating

1. **Check Internet**: Ensure device has internet connection
2. **Manual Update**: Use "Update Filters" in the filter management section
3. **Restart App**: Close and reopen to retry downloads

### Poor Streaming Performance

1. **Disable Unnecessary Filters**: Turn off filter categories you don't need
2. **Check DNS Server**: Try different DNS servers in settings
3. **Restart VPN**: Toggle protection off and on again

### App Crashes

1. **Clear App Data**: Go to Android TV settings → Apps → AuraView → Clear data
2. **Reinstall**: Uninstall and reinstall the app
3. **Check Logs**: Use `adb logcat` to check for error messages

## Technical Details

### Architecture

- **VPN Service**: Uses Android VpnService for traffic interception
- **DNS Filtering**: Intercepts and filters DNS queries at the network level
- **Filter Engine**: High-performance domain matching with Bloom filters
- **Background Updates**: WorkManager for automatic filter updates

### Performance

- **Memory Usage**: ~50MB RAM during operation
- **CPU Usage**: Minimal impact (<5% on most devices)
- **Battery**: Optimized for TV standby modes
- **Network**: Transparent proxying with minimal latency

### Security

- **Local Processing**: All filtering happens on-device
- **No Data Collection**: No telemetry or usage data sent externally
- **Secure Updates**: HTTPS-only filter downloads
- **Permission Minimal**: Only requires VPN permission

## Development

### Building

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

### Testing

```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest

# Run lint checks
./gradlew lint
```

### Code Structure

```
AuraView/
├── app/src/main/java/com/auraview/adblocker/
│   ├── vpn/           # VPN service and controllers
│   ├── filter/        # Filter management and parsing
│   ├── ui/            # Android TV UI components
│   ├── stats/         # Statistics and logging
│   └── utils/         # Utility classes
├── app/src/main/res/  # Android resources
└── build.gradle       # Build configuration
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details.

## Disclaimer

AuraView is provided as-is for educational and personal use. Users are responsible for complying with applicable laws and terms of service when using ad-blocking software. The developers are not responsible for any consequences resulting from the use of this software.

## Support

For issues and questions:

- Create an issue on GitHub
- Check the troubleshooting section above
- Review Android TV compatibility requirements

---

**Enjoy ad-free streaming with AuraView!** 📺✨
