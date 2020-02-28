<?php

namespace App\Http\Controllers\Auth;
use App\User;
use Carbon\Carbon;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;

class AuthController extends Controller
{
    public function login(Request $request) {
        $request->validate([
            //'email' => 'required|string|email',
            'password' => 'required|string'
            //'remember_me' => 'boolean'
        ]);
        $credentials = request(['password']);
        if(!Auth::attempt($credentials))
            return response()->json([
                'message' => 'Unauthorized'
            ], 401);
        $user = $request->user();
        $tokenResult = $user->createToken('Personal Access Token');
        $token = $tokenResult->token;
        if ($request->remember_me)
            $token->expires_at = Carbon::now()->addWeeks(1);
        $token->save();
        return response()->json([
            'access_token' => $tokenResult->accessToken,
            'token_type' => 'Bearer',
            'expires_at' => Carbon::parse(
                $tokenResult->token->expires_at
            )->toDateTimeString()
        ]);
    }
    public function register(Request $request)
    {
        $request->validate([
            'fname' => 'required|string',
            'lname' => 'required|string',
            'email' => 'required|string|email|unique:users',
            'password' => 'required|string',
            'gname'=> 'required|string|gname|unique:users',
            'pnumber'=>'required|string'
        ]);
        $user = new User;
        $user->first_name = $request->fname;
        $user->last_name = $request->lname;
        $user->group_type = $request->gtype;
        $user->group_post = $request->gpost;
        $user->cycle_start_date = $request->sdate;
        $user->cycle_end_date = $request->edate;
        $user->phone_number = $request->pnumber;
        $user->current_home_address = $request->address;
        $user->number_of_members = $request->tmembers;
        $user->email = $request->email;
        $user->group_name = $request->gname;
        $user->password = bcrypt($request->password);
        $user->save();
        return response()->json([
            'message' => 'Successfully created user!'
        ], 201);
    }
    public function logout(Request $request)
    {
        $request->user()->token()->revoke();
        return response()->json([
            'message' => 'Successfully logged out'
        ]);
    }
  
    /**
     * Get the authenticated User
     *
     * @return [json] user object
     */
    public function user(Request $request)
    {
        return response()->json($request->user());
    }
}
