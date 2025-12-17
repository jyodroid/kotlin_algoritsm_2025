//import android.app.Activity
//import android.content.res.Configuration
//import android.os.Bundle
//import android.os.PersistableBundle
//import android.util.Log
//
//class LifecycleActivity : Activity() {
//
//    companion object {
//        const val TAG = "ActivityLifecycle"
//    }
//
//    // ========== CREATION CALLBACKS ==========
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d(TAG, "onCreate() - Activity is being created")
//        // Initialize components, set content view, bind data
//        // Called when activity is first created
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//        Log.d(TAG, "onCreate() with PersistableBundle")
//        // Used for persistent state across device reboots
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG, "onStart() - Activity becoming visible")
//        // Activity is about to become visible
//        // Start animations, register broadcast receivers
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.d(TAG, "onRestoreInstanceState() - Restoring saved state")
//        // Restore UI state after onCreate()
//    }
//
//    override fun onRestoreInstanceState(
//        savedInstanceState: Bundle?,
//        persistentState: PersistableBundle?
//    ) {
//        super.onRestoreInstanceState(savedInstanceState, persistentState)
//        Log.d(TAG, "onRestoreInstanceState() with PersistableBundle")
//    }
//
//    override fun onPostCreate(savedInstanceState: Bundle?) {
//        super.onPostCreate(savedInstanceState)
//        Log.d(TAG, "onPostCreate() - Called after onCreate() completed")
//    }
//
//    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onPostCreate(savedInstanceState, persistentState)
//        Log.d(TAG, "onPostCreate() with PersistableBundle")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG, "onResume() - Activity in foreground, user can interact")
//        // Activity is visible and interactive
//        // Resume paused operations, start camera preview, etc.
//    }
//
//    override fun onPostResume() {
//        super.onPostResume()
//        Log.d(TAG, "onPostResume() - Called after onResume() completed")
//    }
//
//    // ========== RUNNING STATE CALLBACKS ==========
//
//    override fun onAttachedToWindow() {
//        super.onAttachedToWindow()
//        Log.d(TAG, "onAttachedToWindow() - Window attached to activity")
//    }
//
//    override fun onContentChanged() {
//        super.onContentChanged()
//        Log.d(TAG, "onContentChanged() - Content view changed")
//    }
//
//    override fun onUserInteraction() {
//        super.onUserInteraction()
//        Log.d(TAG, "onUserInteraction() - User touched screen/pressed key")
//        // Called whenever user interacts (touch, key press)
//    }
//
//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        Log.d(TAG, "onWindowFocusChanged() - hasFocus: $hasFocus")
//        // Best place to start/stop animations based on focus
//    }
//
//    // ========== CONFIGURATION CHANGE CALLBACKS ==========
//
//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        Log.d(TAG, "onConfigurationChanged() - Configuration changed: $newConfig")
//        // Handle configuration changes (orientation, locale, etc.)
//    }
//
//    // ========== PAUSE/STOP CALLBACKS ==========
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG, "onPause() - Activity losing focus, partially visible")
//        // Pause operations: animations, camera, location updates
//        // Commit unsaved changes, release system resources
//        // Keep it lightweight - affects transition speed
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        Log.d(TAG, "onSaveInstanceState() - Saving UI state")
//        // Save UI state before activity might be destroyed
//    }
//
//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        super.onSaveInstanceState(outState, outPersistentState)
//        Log.d(TAG, "onSaveInstanceState() with PersistableBundle")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG, "onStop() - Activity no longer visible")
//        // Release resources that aren't needed while not visible
//        // Save data, unregister listeners
//    }
//
//    // ========== RESTART CALLBACKS ==========
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(TAG, "onRestart() - Activity restarting after being stopped")
//        // Called before onStart() when restarting stopped activity
//    }
//
//    // ========== DESTRUCTION CALLBACKS ==========
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG, "onDestroy() - Activity being destroyed")
//        // Final cleanup, release all resources
//        // Cancel background tasks, close database connections
//    }
//
//    override fun onDetachedFromWindow() {
//        super.onDetachedFromWindow()
//        Log.d(TAG, "onDetachedFromWindow() - Window detached from activity")
//    }
//
//    // ========== LOW MEMORY CALLBACKS ==========
//
//    override fun onLowMemory() {
//        super.onLowMemory()
//        Log.d(TAG, "onLowMemory() - System running low on memory")
//        // Release non-essential resources
//    }
//
//    override fun onTrimMemory(level: Int) {
//        super.onTrimMemory(level)
//        Log.d(TAG, "onTrimMemory() - level: $level")
//        // Trim memory based on level (more granular than onLowMemory)
//        // Levels: TRIM_MEMORY_RUNNING_LOW, TRIM_MEMORY_UI_HIDDEN, etc.
//    }
//
//    // ========== NEW/TOP INTENT CALLBACKS ==========
//
//    override fun onNewIntent(intent: android.content.Intent?) {
//        super.onNewIntent(intent)
//        Log.d(TAG, "onNewIntent() - New intent received")
//        // Called for singleTop/singleTask when activity already exists
//    }
//
//    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
//        super.onTopResumedActivityChanged(isTopResumedActivity)
//        Log.d(TAG, "onTopResumedActivityChanged() - isTop: $isTopResumedActivity")
//        // Android 10+ (API 29): Called when activity gains/loses top position
//    }
//}
//
///*
//TYPICAL LIFECYCLE FLOWS:
//
//1. App Launch:
//   onCreate() → onStart() → onResume() → Running
//
//2. User Navigates Away:
//   onPause() → onStop()
//
//3. User Returns:
//   onRestart() → onStart() → onResume()
//
//4. Configuration Change (e.g., rotation):
//   onPause() → onStop() → onDestroy() → onCreate() → onStart() → onResume()
//
//5. App Finishing:
//   onPause() → onStop() → onDestroy()
//
//6. Dialog/Partial Obscure:
//   onPause() → (may resume without onStop)
//
//KEY POINTS:
//
//- onCreate/onDestroy: Entire lifetime
//- onStart/onStop: Visible lifetime
//- onResume/onPause: Foreground lifetime (interactive)
//
//- onSaveInstanceState() called before onStop() (may be before or after onPause)
//- onRestoreInstanceState() called between onStart() and onResume()
//
//- System can kill app after onStop() without calling onDestroy()
//- Always save critical data in onPause() or onSaveInstanceState()
//
//- PersistableBundle variants (API 21+) persist across device reboots
//*/