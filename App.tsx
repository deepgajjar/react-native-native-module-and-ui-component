import { useCallback, useState } from "react";
import { View,Text, NativeModules } from "react-native"
import { VideoPlayer } from "./android/src/component/VideoPlayer";

const { ToastModule,TestModule} = NativeModules;
const App = () => {
// native module example
  // return (
  // <View style={
  //   {
  //     flex:1,
  //     justifyContent:'center',
  //     alignItems:'center'
  //   }
  // }>
  // <Text onPress={(e)=>{
  //    ToastModule.showToast("deep gajjar");
  //   TestModule.getDetails(JSON.stringify({first_name:"deep",last_name:"gajjar"})).then((val:any)=>{
  //     console.log("returned data from module ",val)
  //   }).catch((e:any)=>{
  //     console.log("error has occurred in native module ",e)
  //   });
  //   console.log('I am clicked...',e);
  // }}>Click me</Text>    
  // </View>
  // );
  const [paused, setPaused] = useState(false);

  const onVideoLoaded = useCallback(() => {
    console.log('Loaded');
}, []);

const onVideoCompleted = useCallback(() => {
    console.log('Completed');
}, []);

  return(
    <View
        // eslint-disable-next-line react-native/no-inline-styles
        style={{
            flex: 1,
            justifyContent: 'center',
            alignItems: 'center',
        }}>
        <VideoPlayer
            source={
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"
                // 'https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4'
            }
            autoPlay={true}
            paused={paused}
            onLoaded={onVideoLoaded}
            onCompleted={onVideoCompleted}
        />
    </View>
);
}

export default App;