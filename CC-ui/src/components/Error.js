import { useHistory } from "react-router-dom";

function Error() {
    const history = useHistory();
    return <div class="bg-red-100 border-l-4 border-red-500 text-red-700 p-4" role="alert">
        <p class="font-bold">Error</p>
        <p>An error has occurred: </p>
        <p>{history.location.state}</p>
    </div>
}

export default Error;