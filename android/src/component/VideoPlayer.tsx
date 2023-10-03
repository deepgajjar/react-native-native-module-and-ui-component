import { Text, View ,StyleSheet,requireNativeComponent} from "react-native"

const VPlayer = requireNativeComponent('RNVideoPlayer');
export const VideoPlayer = (props:any) => {
    return(
        <View style={[styles.container, props.styles]}>
            <VPlayer
                style={styles.player}
                source={props.source}
                autoPlay={props.autoPlay}
                paused={props.paused}
                onLoaded={props.onLoaded}
                onCompleted={props.onCompleted}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    player: {
        flex: 1,
    },
    container: {
        width: 300,
        height: 300,
    },
});