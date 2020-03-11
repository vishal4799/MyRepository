/*
Please ensure that before submitting, you do not have any console logs in your solution.
 */
//original function
const getRateLimiter = (apiService, limit) => {
  const send = requestId => {
    return new Promise(resolve => {});
  };

  return { send }; // Do not change the return  type
};

/*
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
// Do not change below code or you will be disqualified.
// We suggest you to go through the below code to debug issues.
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
*/

let input = `3
A 8
B 6
C 4
D 6
E 2
F 5
G 4
H 5
I 8`;

function main(input) {
  const lines = input.split("\n");
  const limit = parseInt(lines[0]);
  const requestTuples = lines.slice(1, lines.length).map(tupleStr => {
    let [id, duration] = tupleStr.split(" ");
    id = id.trim();
    duration = parseInt(duration);
    return { id, duration };
  });

  runner(limit, requestTuples);
}

const runner = (limit, requestTuples) => {
  const batchLog = [];

  const apiService = requestID => {
    const log = `START ${requestID}`;
    console.log(log);
    return new Promise((resolve, reject) => {
      const info = requestTuples.find(item => item.id === requestID);
      setTimeout(function() {
        const finishLog = `FINISH ${info.id}`;
        resolve(finishLog);
      }, info.duration * 100);
    });
  };
  const rateLimiter = getRateLimiter(apiService, limit);

  // Runner is going to call send for all API requests at once and in the same order
  // as input testcase
  Promise.all(
    requestTuples.map(r => {
      const requestID = r.id;
      // console.log(`CALLING SEND`);
      // The send function is the one returned from getRateLimiter()
      return rateLimiter
        .send(requestID)
        .then(response => console.log(response));
    })
  );
};

main(input);
